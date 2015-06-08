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
	private Article article;
	private Salle salle;
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
		this(0, new Article(), new Salle(), new HashSet<Intervention>());
	}
	
	
	public Materiel(int id, Article article, Salle salle,
			Set<Intervention> interventions) {
		super();
		this.id = id;
		this.article = article;
		this.salle = salle;
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
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	
	
}
