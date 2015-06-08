package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import beans.Statut;

public class StatutDAO implements IStatutDAO {

	@PersistenceContext
	private EntityManager em;
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Transactional
	public List<Statut> findAll() {
		return em.createQuery("from Statut", Statut.class).getResultList();
	}

	@Transactional
	public Statut findById(int id) {
		return em.find(Statut.class, id);
	}

	@Transactional
	public Statut save(beans.Statut statut) {
		if (statut.getId() > 0) {
			statut = em.merge(statut);
		}
		else {
			em.persist(statut);
		}
		
		return statut;
	}

}
