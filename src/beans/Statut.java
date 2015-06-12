package beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Statut {
	private int id;
	private String label;
	private Set<Intervention> interventions;
	
	@Override
	public String toString() {
		return "Statut [id=" + id + ", label=" + label + "]";
	}

	public Statut(){
		this(0, "", new HashSet<Intervention>());
	}
	
	public Statut(int id, String label, Set<Intervention> interventions) {
		super();
		this.id = id;
		this.label = label;
		this.interventions = interventions;
	}
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	@OneToMany(mappedBy="statut")
	public Set<Intervention> getInterventions() {
		if(interventions == null){
			interventions = new HashSet<Intervention>();
		}
		return interventions;
	}
	public void setInterventions(Set<Intervention> interventions) {
		this.interventions = interventions;
	}
	
}
