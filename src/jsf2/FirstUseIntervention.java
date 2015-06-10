package jsf2;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
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
	private List<Salle> salles;
	private List<Intervenant> intervenants;
	private List<Materiel> materiels;
	private List<Article> articles;
	private List<Batiment> batiments;
	
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
		System.out.println("génération");
		
		statuts = new ArrayList<Statut>();
		salles = new ArrayList<Salle>();
		intervenants = new ArrayList<Intervenant>();
		articles = new ArrayList<Article>();
		batiments = new ArrayList<Batiment>();
		
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
		
		for(int i = 1; i < 3; i++)
		{
			Client c = new Client();
			c.setCodeClient(String.valueOf(i));
			c.setNom("Girard" + i);
			
			c = getClientDAO().save(c);
			
			for(int j = 0; j < 3; j++)
			{
				Site si = new Site();
				si.setLatitude(String.valueOf(getRandomNumber(-100, 100)));
				si.setLongitude(String.valueOf(getRandomNumber(-100, 100)));
				si.setClient(c);
				si = getSiteDAO().save(si);
				
				for(int k = 0; k < 3; k++)
				{
					Batiment b = new Batiment();
					b.setSite(si);
					b.setCodeBatiment("Batiment " + (batiments.size() + 1));
					b = getBatimentDAO().save(b);
					batiments.add(b);
					for(int l = 0; l < getRandomNumber(1, 7); l++)
					{
						Etage e = new Etage();
						e.setBatiment(b);
						e.setCodeEtage(b.getCodeBatiment() + " Etage " + String.valueOf(l));
						
						e = getEtageDAO().save(e);
						
						for(int m = 0; m < getRandomNumber(1, 30); m++)
						{
							Salle s = new Salle();
							s.setEtage(e);
							s.setCodeSalle(e.getCodeEtage() + " Salle " + String.valueOf(m));
							
							s = getSalleDAO().save(s);
							salles.add(s);
						}
					}
				}			
				
			}
		
		}
		
		
		for(int i = 1; i < 22; i++)
		{
			Intervenant intervenant = new Intervenant();
			intervenant.setNom("IBM" + i);
			intervenant.setCodeIntervenant(String.valueOf(i));
			
			intervenant = getIntervenantDAO().save(intervenant);
			
			intervenants.add(intervenant);
		}
		
		
		generateMateriels();
		
		for(int i = 0; i <= 50; i++)
		{
			Intervention intervention = new Intervention();
			intervention.setIntervenant(intervenants.get(getRandomNumber(intervenants.size() - 1)));
			intervention.setMateriel(materiels.get(getRandomNumber(materiels.size() - 1)));
			intervention.setCodeIntervention("Intervention " + i);
			intervention.setStatut(statuts.get(getRandomNumber(0, statuts.size() - 1)));
			
			intervention.setDatePrevu(randomDate());
			intervention.setDateReel(randomDate());
			
			intervention = getInterventionDAO().save(intervention);
		}
		
		return "index";
	}
	
	
	private int getRandomNumber(int max) 
	{
		return getRandomNumber(0, max);
	}
	
	private int getRandomNumber(int min, int max) 
	{
		  return (int) (Math.random() * (max - min) + min);
	}
	
	
	private void generateMateriels()
	{
		generateArticles();
		materiels = new ArrayList<Materiel>();
		
		
		for(Article a: articles)
		{
			for(int i = 0; i < getRandomNumber(1, 20); i++)
			{
				Materiel m = new Materiel();
				m.setArticle(a);
				m.setNumSerie(String.valueOf(getRandomNumber(1, 1000)));
				m.setSalle(salles.get(getRandomNumber(salles.size() - 1)));
				m = getMaterielDAO().save(m);
				materiels.add(m);
			}
		}
	}
	
	private void generateArticles()
	{
		articles = new ArrayList<Article>();
		
		IArticleDAO dao = getArticleDAO();
		
		for(int i = 0; i < getRandomNumber(1, 10); i++)
		{
			Article a = new Article();
			a.setDescription("Article " + i);
			a.setNom(String.valueOf(i));
			
			a = dao.save(a);
			
			articles.add(a);
			
			for(int j = 0; j < getRandomNumber(20); j++)
			{
				Article sa = new Article();
				sa.setArticleParent(a);
				sa.setDescription("Sous Article " + j);
				sa.setNom(String.valueOf(j));
				
				sa = dao.save(sa);
				
				articles.add(sa);
				
				for(int k = 0; k < getRandomNumber(30); k++)
				{
					Article ssa = new Article();
					ssa.setArticleParent(sa);
					ssa.setDescription("Sous sous article " + k);
					ssa.setNom(String.valueOf(k));
					
					ssa = dao.save(ssa);
					
					articles.add(ssa);
				}
			}
			
		}
	}
	
	
	
	
	
    public Date randomDate() {

        GregorianCalendar gc = new GregorianCalendar();

        int year = getRandomNumber(2012, 2015);

        gc.set(gc.YEAR, year);

        int dayOfYear = getRandomNumber(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        System.out.println(gc.get(gc.YEAR) + "-" + gc.get(gc.MONTH) + "-" + gc.get(gc.DAY_OF_MONTH));

		return gc.getTime();
    }
	
}
