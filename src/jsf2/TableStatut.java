package jsf2;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.stereotype.Component;

import beans.Statut;
import utils.IStatutDAO;

@Component
@ManagedBean
public class TableStatut {
	private IStatutDAO statutDAO;
	public IStatutDAO getStatutDAO() {return statutDAO;}
	public void setStatutDAO(IStatutDAO statutDAO) {this.statutDAO = statutDAO;}
	
	private List<Statut> statuts;
	public List<Statut> getStatuts() {
		statuts = getStatutDAO().findAll();
		return statuts;
	}
	
}
