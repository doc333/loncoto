package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import beans.Batiment;

public class BatimentDAO implements IBatimentDAO {
	@PersistenceContext
	private EntityManager em;
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Transactional
	public List<Batiment> findAll() {
		return em.createQuery("from Batiment", Batiment.class).getResultList();
	}

	@Transactional
	public Batiment findById(int id) {
		return em.find(Batiment.class, id);
	}

	@Transactional
	public Batiment save(Batiment batiment) {
		if (batiment.getId() > 0) {
			batiment = em.merge(batiment);
		}
		else {
			em.persist(batiment);
		}
		
		return batiment;
	}

}
