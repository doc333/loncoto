package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import beans.Intervenant;

public class IntervenantDAO implements IIntervenantDAO {
	@PersistenceContext
	private EntityManager em;
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Transactional
	public List<Intervenant> findAll() {
		return em.createQuery("from Intervenant", Intervenant.class).getResultList();
	}
	@Transactional
	public Intervenant findById(int id) {
		return em.find(Intervenant.class, id);
	}
	@Transactional
	public Intervenant save(Intervenant intervenant) {
		if(intervenant.getId() > 0) {
			intervenant = em.merge(intervenant);
		}
		else {
			em.persist(intervenant);
		}
		
		return intervenant;
	}
}
