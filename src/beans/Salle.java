package beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Salle {
	private int id;
	private String codeSalle;
	private Etage etage;
	
	@Override
	public String toString() {
		return "Salle [id=" + id + ", codeSalle=" + codeSalle + ", etage="
				+ etage + "]";
	}
	
	public Salle(){
		this(0, "", new Etage());
	}
	
	public Salle(int id, String codeSalle, Etage etage) {
		super();
		this.id = id;
		this.codeSalle = codeSalle;
		this.etage = etage;
	}
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodeSalle() {
		return codeSalle;
	}
	public void setCodeSalle(String codeSalle) {
		this.codeSalle = codeSalle;
	}
	@ManyToOne
	public Etage getEtage() {
		return etage;
	}
	public void setEtage(Etage etage) {
		this.etage = etage;
	}
	
}
