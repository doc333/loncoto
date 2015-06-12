package jsf2;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

import beans.*;
import utils.IArticleDAO;
import utils.IBatimentDAO;
import utils.IEtageDAO;
import utils.IMaterielDAO;
import utils.ISalleDAO;
import utils.ISiteDAO;

@Component
@ManagedBean
public class EditMateriel {
	
	private IMaterielDAO materielDAO;
	private IArticleDAO articleDAO;
	private ISalleDAO salleDAO;
	private IEtageDAO etageDAO;
	private IBatimentDAO batimentDAO;
	private ISiteDAO siteDAO;
	private List<Batiment> listBatiment;
	private List<Site> listSite;
	private Materiel materiel;
	private List<Article> listArticle;
	private int batimentID;
	private List<Etage> listEtage;
	private int etageID;
	private int salleID;
	private List<Salle> listSalle;
	
	
	public int getSalleID() {
		return salleID;
	}

	public void setSalleID(int salleID) {
		this.salleID = salleID;
	}

	public List<Salle> getListSalle() {
		if (getEtageID() == 0)
			listSalle = getSalleDAO().findAll();
		else
		{
			listSalle = getSalleDAO().findByEtageId(getEtageID());
		}
		return listSalle;
	}

	public void setListSalle(List<Salle> listSalle) {
		this.listSalle = listSalle;
	}

	public int getBatimentID() {
		return batimentID;
	}

	public void setBatimentID(int batimentID) {
		this.batimentID = batimentID;
	}
	
	public List<Etage> getListEtage() {
		if (getBatimentID() == 0)
			listEtage = getEtageDAO().findAll();
		else
		{
			listEtage = getEtageDAO().findByBatimentId(getBatimentID());
		}
		return listEtage;
	}

	public void setListEtage(List<Etage> listEtage) {
		this.listEtage = listEtage;
	}

	public int getEtageID() {
		return etageID;
	}

	public void setEtageID(int etageID) {
		this.etageID = etageID;
	}

	public List<Batiment> getListBatiment() {
		listBatiment = getBatimentDAO().findAll();
		return listBatiment;
	}

	public void setListBatiment(List<Batiment> listBatiment) {
		this.listBatiment = listBatiment;
	}

	public String editMateriel() {
		int id = Integer.parseInt(FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("mid"));
		
		setMateriel(getMaterielDAO().findById(id));
		
		return "editMateriel";
	}

	public String createMateriel() {
		setMateriel(new Materiel());
		return "editMateriel";
	}
	
	public String saveMateriel() {
		getMaterielDAO().save(materiel);
		return "index";
		
	}
	
	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}
	
	

	public List<Article> getListArticle() {
		listArticle = getArticleDAO().findAll();
		return listArticle;
	}

	public void setListArticle(List<Article> listArticle) {
		this.listArticle = listArticle;
	}
	
	public List<Site> getListSite() {
		listSite = getSiteDAO().findAll();
		return listSite;
	}
	public void setListSite(List<Site> listSite) {
		this.listSite = listSite;
	}
	
	
	public IMaterielDAO getMaterielDAO() {
		return materielDAO;
	}
	public void setMaterielDAO(IMaterielDAO materielDAO) {
		this.materielDAO = materielDAO;
	}
	public IArticleDAO getArticleDAO() {
		return articleDAO;
	}
	public void setArticleDAO(IArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}
	public ISalleDAO getSalleDAO() {
		return salleDAO;
	}
	public void setSalleDAO(ISalleDAO salleDAO) {
		this.salleDAO = salleDAO;
	}
	public IEtageDAO getEtageDAO() {
		return etageDAO;
	}
	public void setEtageDAO(IEtageDAO etageDAO) {
		this.etageDAO = etageDAO;
	}
	public IBatimentDAO getBatimentDAO() {
		return batimentDAO;
	}
	public void setBatimentDAO(IBatimentDAO batimentDAO) {
		this.batimentDAO = batimentDAO;
	}
	public ISiteDAO getSiteDAO() {
		return siteDAO;
	}
	public void setSiteDAO(ISiteDAO siteDAO) {
		this.siteDAO = siteDAO;
	}
	
	
	
}
