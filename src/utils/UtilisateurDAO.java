package utils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.transaction.annotation.Transactional;

import beans.Batiment;
import beans.Utilisateur;

public class UtilisateurDAO implements IUtilisateurDAO {
	@PersistenceContext
	private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}	
	
	@Transactional
	public Utilisateur findByEmailAndPassword(String email, String password, boolean isIntervenant) {
		
		String query = "SELECT u FROM Utilisateur as u ";
				if(isIntervenant){
					query += "WHERE u.intervenant IS NOT NULL";
				}
				else {
					query += "WHERE u.intervenant IS NULL";
				}
				query += "AND u.email =:email "
				+ "AND u.password =:password";
		
		
		return em.createQuery("SELECT u FROM Utilisateur as u "
				+ "WHERE u.email =:email "
				+ "AND u.password =:password", Utilisateur.class)
				.setParameter("email", email)
				.setParameter("password", DigestUtils.sha512Hex(password))
				.getSingleResult()
		;
	}
	
	@Transactional
	public Utilisateur findByToken(String token) {
		return em.createQuery("SELECT u from Utilisateur as u "
				+ "LEFT JOIN FETCH u.intervenant as i "
				+ "LEFT JOIN FETCH i.groupes as g "
				+ "LEFT JOIN FETCH i.interventions inter "
				+ "LEFT JOIN FETCH inter.statut s "
				+ "LEFT JOIN FETCH s.interventions i2 "
				+ "WHERE u.token = :token", Utilisateur.class).setParameter("token", token).getSingleResult();
	}	

	@Transactional
	public Utilisateur save(Utilisateur utilisateur) {
		
		utilisateur.setPassword(DigestUtils.sha512Hex(utilisateur.getPassword()));
		
		if (utilisateur.getId() > 0) {
			utilisateur = em.merge(utilisateur);
		}
		else {
			em.persist(utilisateur);
		}
		return utilisateur;
	}

}
