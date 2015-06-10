package jsf2;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import beans.Utilisateur;
import utils.IUtilisateurDAO;

@Component
@ManagedBean
public class ConnectUtilisateur {
	
	private String email;
	private String password;
	
	private Utilisateur utilisateur;
	private IUtilisateurDAO utilisateurDAO;
	
	public void setUtilisateurDAO(IUtilisateurDAO utilisateurDAO){ 
		this.utilisateurDAO = utilisateurDAO; 
	}
	public IUtilisateurDAO getUtilisateurDAO(){
		return utilisateurDAO; 
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String connect()
	{
		try{
			utilisateur = getUtilisateurDAO().findByEmailAndPassword(email, password);
		}
		catch (NoResultException e) {
			return "index";
		}
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute("utilisateur", utilisateur);
		
		return "index";
	}
	
	public String disconnect()
	{
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.removeAttribute("utilisateur");
		
		return "index";
	}

}
