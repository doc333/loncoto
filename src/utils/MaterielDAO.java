package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import beans.Materiel;

public class MaterielDAO implements IMaterielDAO {
	@PersistenceContext
	private EntityManager em;
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Transactional
	public List<Materiel> findAll() {
		return em.createQuery("from Materiel", Materiel.class).getResultList();
	}
	@Transactional
	public Materiel findById(int id) {
		return em.find(Materiel.class, id);
	}
	@Transactional
	public Materiel save(Materiel materiel) {
		if (materiel.getId() > 0) {
			materiel = em.merge(materiel);
		}
		else {
			em.persist(materiel);
		}
		
		return materiel;
	}
	
	
}
