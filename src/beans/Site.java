package beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Site {
	private int id;
	private String latitude;
	private String longitude;
	private Set<Client> clients;
	private Set<Batiment> batiments;
	
	@OneToMany(mappedBy="site")
	public Set<Batiment> getBatiments() {
		if(batiments == null){
			batiments = new HashSet<Batiment>();
		}
		return batiments;
	}

	public void setBatiments(Set<Batiment> batiments) {
		this.batiments = batiments;
	}

	@Override
	public String toString() {
		return latitude + ":" + longitude;
	}
	
	public Site(){
		this(0, "", "", new HashSet<Client>());
	}
	
	
	public Site(int id, String latitude, String longitude, Set<Client> clients) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.clients = clients;
	}
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	@ManyToMany(mappedBy="sites", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	
	
}
