package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import beans.Article;
import beans.Etage;

public class EtageDAO implements IEtageDAO {
	@PersistenceContext
	private EntityManager em;
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Transactional
	public List<Etage> findAll() {
		return em.createQuery("from Etage", Etage.class).getResultList();
	}

	@Transactional
	public Etage findById(int id) {
		return em.find(Etage.class, id);
	}
	
	@Transactional
	public List<Etage> findByBatimentId(int id){
		TypedQuery<Etage> q = em.createQuery("select e from Etage as e"
				+ " right join e.batiment as b"
				+ " where b.id = :id", Etage.class);
		
		q.setParameter("id", id);
		
		return q.getResultList();
	}
	
	@Transactional
	public Etage save(Etage etage) {
		if (etage.getId() > 0 ) {
			etage = em.merge(etage);
		}
		else {
			em.persist(etage);
		}
		
		return etage;
	}

}
