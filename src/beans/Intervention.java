package beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Intervention {
	private int id;
	private String codeIntervention;
	private Date datePrevu;
	private Date dateReel;
	private String commentaire;
	private Statut status;
	private Materiel materiel;
	private Intervenant intervenant;
	
	
	@Override
	public String toString() {
		return "Intervention [id=" + id + ", codeIntervention="
				+ codeIntervention + ", datePrevu=" + datePrevu + ", dateReel="
				+ dateReel + ", commentaire=" + commentaire + ", status="
				+ status + ", materiel=" + materiel + ", intervenant="
				+ intervenant + "]";
	}
	
	public Intervention(){
		this(0, "", null, null, "", new Statut(), new Materiel(), new Intervenant());
	}
	
	public Intervention(int id, String codeIntervention, Date datePrevu,
			Date dateReel, String commentaire, Statut status,
			Materiel materiel, Intervenant intervenant) {
		super();
		this.id = id;
		this.codeIntervention = codeIntervention;
		this.datePrevu = datePrevu;
		this.dateReel = dateReel;
		this.commentaire = commentaire;
		this.status = status;
		this.materiel = materiel;
		this.intervenant = intervenant;
	}
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodeIntervention() {
		return codeIntervention;
	}
	public void setCodeIntervention(String codeIntervention) {
		this.codeIntervention = codeIntervention;
	}
	public Date getDatePrevu() {
		return datePrevu;
	}
	public void setDatePrevu(Date datePrevu) {
		this.datePrevu = datePrevu;
	}
	public Date getDateReel() {
		return dateReel;
	}
	public void setDateReel(Date dateReel) {
		this.dateReel = dateReel;
	}
	@ManyToOne
	public Statut getStatus() {
		return status;
	}
	public void setStatus(Statut status) {
		this.status = status;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	@ManyToOne
	public Materiel getMateriel() {
		return materiel;
	}
	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}
	@ManyToOne
	public Intervenant getIntervenant() {
		return intervenant;
	}
	public void setIntervenant(Intervenant intervenant) {
		this.intervenant = intervenant;
	}
	
	
}
