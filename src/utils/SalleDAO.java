package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.sun.org.apache.regexp.internal.recompile;

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
