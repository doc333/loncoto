package jsf2;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

import beans.Statut;
import utils.IStatutDAO;

@Component
@ManagedBean
public class EditStatut {

	private IStatutDAO statutDAO;
	public IStatutDAO getStatutDAO() {return statutDAO;}
	public void setStatutDAO(IStatutDAO statutDAO) {this.statutDAO = statutDAO;	}
	
	private Statut statut;
	public Statut getStatut() {return statut;}
	public void setStatut(Statut statut) {this.statut = statut;}
	
	public String editStatut() {
		int sid = Integer.parseInt(FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("sid"));
		
		setStatut(getStatutDAO().findById(sid));
		
		return "editStatut";
	}
	
	public String createStatut() {
		setStatut(new Statut());
		
		return "editStatut";
	}
	
	public String saveStatut() {
		getStatutDAO().save(getStatut());
		return "listStatut";
	}
}
