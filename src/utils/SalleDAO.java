package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import com.sun.org.apache.regexp.internal.recompile;

import beans.Etage;
import beans.Salle;

public class SalleDAO implements ISalleDAO {
	@PersistenceContext
	private EntityManager em;
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Transactional
	public List<Salle> findAll() {
		return em.createQuery("from Salle", Salle.class).getResultList();
	}

	@Transactional
	public Salle findById(int id) {
		return em.find(Salle.class, id);
	}
	
	@Transactional
	public List<Salle> findByEtageId(int id){
		TypedQuery<Salle> q = em.createQuery("select s from Salle as s"
				+ " right join s.etage as e"
				+ " where e.id = :id", Salle.class);
		
		q.setParameter("id", id);
		
		return q.getResultList();
	}
	
	@Transactional
	public Salle save(Salle salle) {
		if (salle.getId() > 0) {
			salle = em.merge(salle);
		}
		else {
			em.persist(salle);
		}
		
		return salle;
	}

}
