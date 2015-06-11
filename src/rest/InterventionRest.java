package rest;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import utils.IInterventionDAO;
import beans.Intervention;


@Controller
public class InterventionRest {
	
	private IInterventionDAO interventionDAO;
	
	public IInterventionDAO getInterventionDAO() {
		return interventionDAO;
	}
	public void setInterventionDAO(IInterventionDAO interventionDAO) {
		this.interventionDAO = interventionDAO;
	}

	@RequestMapping("/interventions")
	public @ResponseBody List<Intervention> getInterventions() {
		System.out.println("dans rest -> getIntervention");
		return getInterventionDAO().findAll();
	}
	
	@RequestMapping("/intervention")
	public @ResponseBody Intervention findIntervention(@RequestParam(value="cid", defaultValue="1") int id) {
		return getInterventionDAO().findById(id);
	}
	
	@RequestMapping("/intervention/{interventionId}")
	public @ResponseBody Intervention findIntervention2(@PathVariable("interventionId") int id) {
		return getInterventionDAO().findById(id);
	}
	
}
