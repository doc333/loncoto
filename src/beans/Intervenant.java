package beans;
import java.io.Serializable;
import java.util.ArrayList;
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
	@OneToMany(mappedBy="intervenant")
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
	
	public static boolean commonGroupe(Intervenant i1, Intervenant i2)
	{
		
		if(i1.getId() == i2.getId())
		{
			return true;
		}		
		
		if(i1.getGroupes().isEmpty() || i2.getGroupes().isEmpty())
		{
			return false;
		}
		
		Object[] grps1 = i1.getGroupes().toArray();
		Object[] grps2 = i2.getGroupes().toArray();
		int i = 0;
		boolean commonGroupe = false;
		
		
		while(i < grps1.length && !commonGroupe)
		{
			int j = 0;
			while(j < grps2.length && !commonGroupe){
				commonGroupe = grps1[i] == grps2[j];
				j++;
			}
			i++;
		}
		
		return commonGroupe;
	}
	
}
