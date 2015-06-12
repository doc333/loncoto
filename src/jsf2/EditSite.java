package jsf2;

import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

import beans.Client;
import beans.Site;
import utils.IClientDAO;
import utils.ISiteDAO;

@Component
@ManagedBean
public class EditSite {
	private int siteID;
	private ISiteDAO siteDAO;
	private IClientDAO clientDAO;
	private Set<Client> clients;
	private Site site;
	
	
	public IClientDAO getClientDAO() {return clientDAO;}
	public void setClientDAO(IClientDAO clientDAO) {this.clientDAO = clientDAO;}
	public int getSiteID() {return siteID;}
	public void setSiteID(int siteID) {	this.siteID = siteID;}
	public ISiteDAO getSiteDAO() {return siteDAO;}
	public void setSiteDAO(ISiteDAO siteDAO) {this.siteDAO = siteDAO;}
	public List<Client> getClients() {return clientDAO.findAll();}
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	
	public String saveSite() {
		getSiteDAO().save(site);
		return "index";
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	
	public String editSite() {
		int id = Integer.parseInt(FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("sid"));
		
		setSite(getSiteDAO().findById(id));
		
		return "editSite";
	}
	
	public String createSite() {
		setSite(new Site());
		return "editSite";
	}
	
}
