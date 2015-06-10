package jsf2;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import beans.Utilisateur;
import utils.IUtilisateurDAO;

@Component
@ManagedBean
public class ConnectUtilisateur {
	
	private Utilisateur utilisateur;
	private IUtilisateurDAO utilisateurDAO;
	
	public void setUtilisateurDAO(IUtilisateurDAO utilisateurDAO){ this.utilisateurDAO = utilisateurDAO; }
	public IUtilisateurDAO getUtilisateurDAO(){ return utilisateurDAO; }
	
	public String connect(String email, String password)
	{
		
		utilisateur = getUtilisateurDAO().findByEmailAndPassword(email, password);
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		
		session.setAttribute("utilisateur", utilisateur);
		
		return "index";
	}

}
