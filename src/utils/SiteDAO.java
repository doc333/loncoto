package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import beans.Site;

public class SiteDAO implements ISiteDAO {
	@PersistenceContext
	private EntityManager em;
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Transactional
	public List<Site> findAll() {
		return em.createQuery("from Site", Site.class).getResultList();
	}

	@Transactional
	public Site findById(int id) {
		return em.find(Site.class, id);
	}

	@Transactional
	public Site save(Site site) {
		if (site.getId() > 0) {
			site = em.merge(site);
		}
		else {
			em.persist(site);
		}
		
		return site;
	}

}
