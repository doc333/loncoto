package beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(
	uniqueConstraints=@UniqueConstraint(columnNames = { "email" })
)
public class Utilisateur {
	private int id;
	private String email;
	private String password;
	private Intervenant intervenant;
	
	public Utilisateur(){
		this(0, "", "", null);
	}
	
	public Utilisateur(int id, String email, String password, Intervenant intervenant) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.intervenant = intervenant;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", email=" + email + ", password="
				+ password + ", intervenant=" + intervenant + "]";
	}

	@Id @GeneratedValue	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@OneToOne @JsonIgnore
	public Intervenant getIntervenant() {
		return intervenant;
	}
	public void setIntervenant(Intervenant intervenant) {
		this.intervenant = intervenant;
	}
	
	
}
