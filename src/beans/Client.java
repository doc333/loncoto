package beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Client {
	private int id;
	private String codeClient;
	private String nom;
	private Set<Site> sites;
	
	public Client(){
		this(0, "", "", new HashSet<Site>());
	}
	
	public Client(int id, String codeClient, String nom, Set<Site> sites) {
		super();
		this.id = id;
		this.codeClient = codeClient;
		this.nom = nom;
		this.sites = sites;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", codeClient=" + codeClient + ", nom="
				+ nom + ", sites=" + sites + "]";
	}
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(String codeClient) {
		this.codeClient = codeClient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@JsonIgnore
	@OneToMany
	public Set<Site> getSites() {
		if(sites == null){
			sites = new HashSet<Site>();
		}
		return sites;
	}
	public void setSites(Set<Site> sites) {
		this.sites = sites;
	}
	
	
	
}
