package beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Article {
	private int id;
	private String nom;
	private String description;
	private Set<Materiel> materiels;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="article")
	public Set<Materiel> getMateriels() {
		if (materiels == null)
			materiels = new HashSet<Materiel>();
		return materiels;
	}

	public void setMateriels(Set<Materiel> materiels) {
		this.materiels = materiels;
	}

	public Article(){
		this(0, "", "", new HashSet<Materiel>());
	}
	
	public Article(int id, String nom, String description,
			Set<Materiel> materiels) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.materiels = materiels;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", nom=" + nom + ", description="
				+ description + "]";
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
