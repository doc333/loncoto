package jsf2;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import beans.*;

@Component
@ManagedBean
public class FirstUseIntervention {
	
	
	@PersistenceContext
	private EntityManager em;
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public String generateInterventions()
	{
		for(int i = 0; i <= 100; i++)
		{
			
			Intervention intervention = new Intervention();
			Intervenant intervenant = new Intervenant();
			Materiel m = new Materiel();
			Article a = new Article();
			Salle s = new Salle();
			Etage e = new Etage();
			Batiment b = new Batiment();
			Site si = new Site();
			Client c = new Client();
			
			c.setCodeClient("Client " + i);
			c.setNom("IBM " + i);
			
			si.setClient(c);;
			si.setLatitude("654151" + i);
			si.setLongitude("65484" + i);
			b.setSite(si);
			
			b.setCodeBatiment("Batiment " + i);
			e.setBatiment(b);
			e.setCodeEtage("Etage " + i);
			s.setEtage(e);
			a.setDescription("Super article " + i);
			a.setNom("Article " + i);
			
			m.setArticle(a);
			m.setSalle(s);
			intervenant.setCodeIntervenant("Intervenant " + i);
			intervenant.setNom("GIRARD " + i);
			intervention.setIntervenant(intervenant);
			intervention.setMateriel(m);
			intervention.setCodeIntervention("Intervention " + i);
			
			em.persist(c);
			em.persist(si);
			em.persist(b);
			em.persist(e);
			em.persist(s);
			em.persist(a);
			em.persist(m);
			em.persist(intervenant);
			em.persist(intervention);
			
		}
		
		return "index";
	}
	
}
