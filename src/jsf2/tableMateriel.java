package jsf2;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.stereotype.Component;

import beans.Materiel;
import utils.IMaterielDAO;

@Component
@ManagedBean
public class tableMateriel {
	private IMaterielDAO materielDAO;
	private List<Materiel> materiels;
	
	public IMaterielDAO getMaterielDAO() {
		return materielDAO;
	}
	public void setMaterielDAO(IMaterielDAO materielDAO) {
		this.materielDAO = materielDAO;
	}
	public List<Materiel> getMateriels() {
		return materielDAO.findAll();
	}
	public void setMateriels(List<Materiel> materiels) {
		this.materiels = materiels;
	}
	
	
}
