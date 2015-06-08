package beans;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Groupe {
	private int id;
	private String nom;
	private Set<Intervenant> intervenants;
	
	public Groupe(){
		this(0, "", new HashSet<Intervenant>());
	}
	public Groupe(int id, String nom, Set<Intervenant> intervenants) {
		super();
		this.id = id;
		this.nom = nom;
		this.intervenants = intervenants;
	}
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	public Set<Intervenant> getIntervenants() {
		return intervenants;
	}
	public void setIntervenants(Set<Intervenant> intervenants) {
		this.intervenants = intervenants;
	}
	
	
}
