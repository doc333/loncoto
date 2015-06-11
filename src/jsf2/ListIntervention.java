package jsf2;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

import beans.Intervention;
import utils.IInterventionDAO;

@Component
@ManagedBean
public class ListIntervention {
	private IInterventionDAO interventionDAO;
	private List<Intervention> interventions;
	private long nbInterventions = 0;
	
	public IInterventionDAO getInterventionDAO() {
		return interventionDAO;
	}
	public void setInterventionDAO(IInterventionDAO interventionDAO) {
		this.interventionDAO = interventionDAO;
	}
	
	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}
	
	public long getNbInterventions()
	{
		if(nbInterventions == 0)
		{
			nbInterventions = getInterventionDAO().countInterventions();
		}
		return nbInterventions;
	}
	public List<Intervention> getInterventions() {
		
		if(interventions == null) {
			interventions = interventionDAO.findPage(0);
		}
		
		return interventions;
	}
	
	public void getInterventionsForPage() {
		int page = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("page"));
		setInterventions(getInterventionDAO().findPage(page));
	}
	
}
