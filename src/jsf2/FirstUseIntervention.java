package jsf2;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import utils.IArticleDAO;
import utils.IBatimentDAO;
import utils.IClientDAO;
import utils.IEtageDAO;
import utils.IIntervenantDAO;
import utils.IInterventionDAO;
import utils.IMaterielDAO;
import utils.ISalleDAO;
import utils.ISiteDAO;
import utils.IStatutDAO;
import beans.*;

@Component
@ManagedBean
public class FirstUseIntervention {
	
	
	private IArticleDAO articleDAO;
	private IClientDAO clientDAO;
	private IIntervenantDAO intervenantDAO;
	private IInterventionDAO interventionDAO;
	private IMaterielDAO materielDAO;
	private IStatutDAO statutDAO;
	private ISalleDAO salleDAO;
	private IBatimentDAO batimentDAO;
	private ISiteDAO siteDAO;
	private IEtageDAO etageDAO;
	
	private List<Statut> statuts;
	
	
	public IArticleDAO getArticleDAO() {return articleDAO;}
	public void setArticleDAO(IArticleDAO articleDAO) {	this.articleDAO = articleDAO;}
	public IClientDAO getClientDAO() {	return clientDAO;}
	public void setClientDAO(IClientDAO clientDAO) {this.clientDAO = clientDAO;}
	public IIntervenantDAO getIntervenantDAO() {return intervenantDAO;}
	public void setIntervenantDAO(IIntervenantDAO intervenantDAO) {	this.intervenantDAO = intervenantDAO;}
	public IInterventionDAO getInterventionDAO() {	return interventionDAO;}
	public void setInterventionDAO(IInterventionDAO interventionDAO) {this.interventionDAO = interventionDAO;}
	public IMaterielDAO getMaterielDAO() {return materielDAO;}
	public void setMaterielDAO(IMaterielDAO materielDAO) {this.materielDAO = materielDAO;}
	public IStatutDAO getStatutDAO() {return statutDAO;}
	public void setStatutDAO(IStatutDAO statutDAO) {this.statutDAO = statutDAO;	}
	public ISalleDAO getSalleDAO() {	return salleDAO;	}
	public void setSalleDAO(ISalleDAO salleDAO) {	this.salleDAO = salleDAO;	}
	public IBatimentDAO getBatimentDAO() {	return batimentDAO;	}
	public void setBatimentDAO(IBatimentDAO batimentDAO) {this.batimentDAO = batimentDAO;	}
	public ISiteDAO getSiteDAO() {	return siteDAO;	}
	public void setSiteDAO(ISiteDAO siteDAO) {this.siteDAO = siteDAO;}
	public IEtageDAO getEtageDAO() {return etageDAO;}
	public void setEtageDAO(IEtageDAO etageDAO) {this.etageDAO = etageDAO;}
	
	public String generateInterventions()
	{
		
		statuts = new ArrayList<Statut>();
		
		Statut s1 = new Statut();
		s1.setLabel("En cours");
		Statut s2 = new Statut();
		s2.setLabel("Dépassé");
		Statut s3 = new Statut();
		s3.setLabel("Fini");
		
		s1 = getStatutDAO().save(s1);
		s2 = getStatutDAO().save(s2);
		s3 = getStatutDAO().save(s3);
		
		statuts.add(s1);
		statuts.add(s2);
		statuts.add(s3);
		
		
		
		for(int i = 0; i <= 100; i++)
		{
			System.out.println("génération");
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
			System.out.println("--------------------------------------------");
			intervention.setStatut(statuts.get((int) Math.random() * (statuts.size() -1)));
			
			c = getClientDAO().save(c);
			si = getSiteDAO().save(si);
			b = getBatimentDAO().save(b);
			e = getEtageDAO().save(e);
			s = getSalleDAO().save(s);
			a = getArticleDAO().save(a);
			m = getMaterielDAO().save(m);
			
			intervenant = getIntervenantDAO().save(intervenant);
			intervention = getInterventionDAO().save(intervention);
		}
		
		return "index";
	}
	
}
