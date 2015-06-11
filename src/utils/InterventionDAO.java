package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import beans.Intervention;

public class InterventionDAO implements IInterventionDAO {
	
	@PersistenceContext
	private EntityManager em;
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Transactional
	public List<Intervention> findAll() {
		return em.createQuery("from Intervention", Intervention.class).getResultList();
	}

	@Transactional
	public Intervention findById(int id) {
		return em.find(Intervention.class, id);
	}

	@Transactional
	public Intervention save(Intervention intervention) {
		if (intervention.getId() > 0) {
			intervention = em.merge(intervention);
		}
		else {
			em.persist(intervention);
		}
		return intervention;
	}
	@Transactional
	public List<Intervention> findPage(int page) {
		return em.createQuery("from Intervention", Intervention.class).setFirstResult(page * 25).setMaxResults(25).getResultList();
	}
	
	@Transactional
	public long countInterventions() {
		return (long) em.createQuery("SELECT COUNT(*) FROM Intervention").getSingleResult();
	}

}
