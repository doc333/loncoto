package jsf2;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.stereotype.Component;

import beans.Site;
import utils.ISiteDAO;

@Component
@ManagedBean
public class tableSites {
	private ISiteDAO siteDAO;
	private List<Site> sites;
	
	public ISiteDAO getSiteDAO() {
		return siteDAO;
	}
	public void setSiteDAO(ISiteDAO siteDAO) {
		this.siteDAO = siteDAO;
	}
	public List<Site> getSites() {
		return siteDAO.findAll();
	}
	public void setSites(List<Site> sites) {
		this.sites = sites;
	}
	
	
}
