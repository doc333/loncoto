package beans;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Intervenant {
	private int id;
	private String codeIntervenant;
	private String nom;
	private Set<Groupe> groupes;
	private Set<Intervention> interventions;
	
	
	@JsonIgnore
	@OneToMany
	public Set<Intervention> getInterventions() {
		if(interventions == null){
			interventions = new HashSet<Intervention>();
		}
		return interventions;
	}

	public void setInterventions(Set<Intervention> interventions) {
		this.interventions = interventions;
	}

	@Override
	public String toString() {
		return "Intervenant [id=" + id + ", codeIntervenant=" + codeIntervenant
				+ ", nom=" + nom + ", groupes=" + groupes + "]";
	}

	public Intervenant(){
		this(0, "", "", new HashSet<Groupe>(), new HashSet<Intervention>());
	}
	
	
	public Intervenant(int id, String codeIntervenant, String nom,
			Set<Groupe> groupes, Set<Intervention> interventions) {
		super();
		this.id = id;
		this.codeIntervenant = codeIntervenant;
		this.nom = nom;
		this.groupes = groupes;
		this.interventions = interventions;
	}
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodeIntervenant() {
		return codeIntervenant;
	}
	public void setCodeIntervenant(String codeIntervenant) {
		this.codeIntervenant = codeIntervenant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@ManyToMany(cascade=CascadeType.PERSIST, mappedBy="intervenants")
	public Set<Groupe> getGroupes() {
		return groupes;
	}
	public void setGroupes(Set<Groupe> groupes) {
		this.groupes = groupes;
	}
	
	
	
}
