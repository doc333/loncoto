package rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import beans.Utilisateur;
import utils.IUtilisateurDAO;

@Controller
public class UtilisateurRest {
	private IUtilisateurDAO utilisateurDAO;

	public IUtilisateurDAO getUtilisateurDAO() {
		return utilisateurDAO;
	}

	public void setUtilisateurDAO(IUtilisateurDAO utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}
		
	
	@RequestMapping("/connection/{email}/{password}")
	public @ResponseBody Utilisateur findUtilisateur(@PathVariable("email") String email, @PathVariable("password") String password)
	{
		return getUtilisateurDAO().findByEmailAndPassword(email, password);
	}	
}
