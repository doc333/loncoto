package jsf2;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

import beans.Intervenant;
import beans.Intervention;
import beans.Materiel;
import beans.Statut;
import utils.IIntervenantDAO;
import utils.IInterventionDAO;
import utils.IMaterielDAO;
import utils.IStatutDAO;

@Component
@ManagedBean
public class EditIntervention {
	private IInterventionDAO interventionDAO;
	public IInterventionDAO getInterventionDAO() {
		return interventionDAO;
	}
	public void setInterventionDAO(IInterventionDAO interventionDAO) {
		this.interventionDAO = interventionDAO;
	}
	
	private IStatutDAO statutDAO;
	public IStatutDAO getStatutDAO() {
		return statutDAO;
	}
	public void setStatutDAO(IStatutDAO statutDAO) {
		this.statutDAO = statutDAO;
	}
	
	private IMaterielDAO materielDAO;
	public IMaterielDAO getMaterielDAO() {
		return materielDAO;
	}
	public void setMaterielDAO(IMaterielDAO materielDAO) {
		this.materielDAO = materielDAO;
	}
	
	private IIntervenantDAO intervenantDAO;
	public IIntervenantDAO getIntervenantDAO() {
		return intervenantDAO;
	}
	public void setIntervenantDAO(IIntervenantDAO intervenantDAO) {
		this.intervenantDAO = intervenantDAO;
	}

	private Intervention intervention;
	public Intervention getIntervention() {
		return intervention;
	}
	public void setIntervention(Intervention intervention) {
		this.intervention = intervention;
	}
	
	private List<Statut> listStatut;
	public List<Statut> getListStatut() {
		listStatut = getStatutDAO().findAll();
		return listStatut;
	}
	public void setListStatut(List<Statut> listStatut) {
		this.listStatut = listStatut;
	}
	
	private List<Materiel> listMateriel;
	public List<Materiel> getListMateriel() {
		listMateriel = getMaterielDAO().findAll();
		return listMateriel;
	}
	public void setListMateriel(List<Materiel> listMateriel) {
		this.listMateriel = listMateriel;
	}
	
	private List<Intervenant> listIntervenant;
	public List<Intervenant> getListIntervenant() {
		listIntervenant = getIntervenantDAO().findAll();
		return listIntervenant;
	}
	public void setListIntervenant(List<Intervenant> listIntervenant) {
		this.listIntervenant = listIntervenant;
	}
	
	public String editIntervention() {
		int iid = Integer.parseInt(FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("iid"));
		
		setIntervention(getInterventionDAO().findById(iid));
		
		return "editIntervention";
	}
	
	public String createIntervention() {
		setIntervention(new Intervention());
		return "editIntervention";
	}
	
	public String saveIntervention() {
		getInterventionDAO().save(intervention);
		return "index";
	}
}
