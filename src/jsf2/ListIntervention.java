package jsf2;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.stereotype.Component;

import beans.Intervention;
import utils.IInterventionDAO;

@Component
@ManagedBean
public class ListIntervention {
	private IInterventionDAO interventionDAO;
	public IInterventionDAO getInterventionDAO() {
		return interventionDAO;
	}
	public void setInterventionDAO(IInterventionDAO interventionDAO) {
		this.interventionDAO = interventionDAO;
	}
	
	
	private List<Intervention> interventions;
	public List<Intervention> getInterventions() {
		return interventionDAO.findAll();
	}
	
	
}
