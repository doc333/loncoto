package rest;


import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import utils.IInterventionDAO;
import utils.IUtilisateurDAO;
import beans.Intervenant;
import beans.Intervention;
import beans.Utilisateur;


@Controller
public class InterventionRest {
	
	private IInterventionDAO interventionDAO;
	private IUtilisateurDAO utilisateurDAO;
	
	public IInterventionDAO getInterventionDAO() {
		return interventionDAO;
	}
	public void setInterventionDAO(IInterventionDAO interventionDAO) {
		this.interventionDAO = interventionDAO;
	}

	
	public IUtilisateurDAO getUtilisateurDAO() {
		return utilisateurDAO;
	}

	public void setUtilisateurDAO(IUtilisateurDAO utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}	
	
	
	@RequestMapping("/interventions/{token}")
	public @ResponseBody Set<Intervention> getInterventions(@PathVariable("token") String token) {
		Utilisateur utilisateur = getUtilisateurDAO().findByToken(token);
		Intervenant i = utilisateur.getIntervenant();
		return i.getInterventions();
	}
	
	@RequestMapping("/intervention/{token}")
	public @ResponseBody Intervention findIntervention(@RequestParam(value="cid", defaultValue="1") int id, @PathVariable("token") String token) {
		return getInterventionDAO().findById(id);
	}
	
	@RequestMapping("/intervention/{token}/{interventionId}")
	public @ResponseBody Intervention findIntervention2(@PathVariable("token") String token, @PathVariable("interventionId") int id) {
		return getInterventionDAO().findById(id);
	}
	
}
