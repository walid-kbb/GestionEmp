package tp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employe {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Long id;
	private String nom;
	private String prenom;
	private String adressMail;
	
	@ManyToOne
	@JoinColumn(name="idDepart")
	private Departement departement ;
	
	public Employe() {
		
	}
	public Employe(String nom, String prenom, String adressMail,Departement dep) {
		this.nom = nom;
		this.prenom = prenom;
		this.adressMail = adressMail;
		this.departement=dep ;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdressMail() {
		return adressMail;
	}
	public void setAdressMail(String adressMail) {
		this.adressMail = adressMail;
	}
	
	
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	@Override
	public String toString() {
		return "Employe [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adressMail=" + adressMail + "]";
	}

	
}
