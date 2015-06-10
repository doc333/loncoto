package utils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.transaction.annotation.Transactional;

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
	public Utilisateur findByEmailAndPassword(String email, String password) {
		return em.createQuery("SELECT * FROM utilisateur as u "
				+ "WHERE email =:email "
				+ "AND password =:password", Utilisateur.class)
				.setParameter("email", email)
				.setParameter("password", DigestUtils.sha512Hex(password))
				.getSingleResult()
		;
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
