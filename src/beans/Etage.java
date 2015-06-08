package beans;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;


@Entity
public class Etage {
	private int id;
	private String codeEtage;
	private Batiment batiment;
	private Set<Salle> salles;
	
	@Override
	public String toString() {
		return "Etage [id=" + id + ", codeEtage=" + codeEtage + ", batiment="
				+ batiment + "]";
	}

	public Etage(){
		this(0, "", new Batiment());
	}
	
	public Etage(int id, String codeEtage, Batiment batiment) {
		super();
		this.id = id;
		this.codeEtage = codeEtage;
		this.batiment = batiment;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy="etage")
	public Set<Salle> getSalles() {
		if(salles == null){
			salles = new HashSet<Salle>();
		}
		return salles;
	}

	public void setSalles(Set<Salle> salles) {
		this.salles = salles;
	}
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodeEtage() {
		return codeEtage;
	}
	public void setCodeEtage(String codeEtage) {
		this.codeEtage = codeEtage;
	}
	@ManyToOne
	public Batiment getBatiment() {
		return batiment;
	}
	public void setBatiment(Batiment batiment) {
		this.batiment = batiment;
	}
	
	
	
	
}