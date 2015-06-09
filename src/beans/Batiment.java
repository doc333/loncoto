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
public class Batiment {
	private int id;
	private String codeBatiment;
	private Site site;
	private Set<Etage> etages;
	
	@OneToMany
	public Set<Etage> getEtages() {
		if(etages == null){
			etages = new HashSet<Etage>();
		}
		return etages;
	}

	public void setEtages(Set<Etage> etages) {
		this.etages = etages;
	}

	@Override
	public String toString() {
		return "Batiment [id=" + id + ", codeBatiment=" + codeBatiment
				+ ", site=" + site + "]";
	}
	
	public Batiment(){
		this(0, "", new Site(), new HashSet<Etage>());
	}
	
	
	public Batiment(int id, String codeBatiment, Site site, Set<Etage> etages) {
		super();
		this.id = id;
		this.codeBatiment = codeBatiment;
		this.site = site;
		this.etages = etages;
	}
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodeBatiment() {
		return codeBatiment;
	}
	public void setCodeBatiment(String codeBatiment) {
		this.codeBatiment = codeBatiment;
	}
	
	@ManyToOne
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	
	
}
