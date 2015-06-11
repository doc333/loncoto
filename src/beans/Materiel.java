package beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Materiel {
	private int id;
	private String numSerie;
	private Article article;
	private Salle salle;
	private Client client;
	private Set<Intervention> interventions;
		
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
		return "Materiel [id=" + id + ", article=" + article + ", salle="
				+ salle + "]";
	}
	
	public Materiel(){
		this(0, "", new Article(), new Salle(), new Client(), new HashSet<Intervention>());
	}
	
	
	public Materiel(int id, String numSerie, Article article, Salle salle,
			Client client, Set<Intervention> interventions) {
		super();
		this.id = id;
		this.numSerie = numSerie;
		this.article = article;
		this.salle = salle;
		this.client = client;
		this.interventions = interventions;
	}
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	@ManyToOne
	public Salle getSalle() {
		return salle;
	}
	@ManyToOne
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	
	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	
}
