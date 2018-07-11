package deTendresAnimaux.bdd;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Client implements User1 {

	@Id
	@GeneratedValue
	private Integer idclient;

	@ManyToOne
	private Droit droit;

	private String nom;

	private String prenom;

	private String adresse;

	private String telephone;

	private String email;

	private LocalDate dateDeNaissance;

	private String motDePasse;

	
	public Client() {
		
	}
	public Client(String nom, String prenom, String adresse, String telephone, String email, LocalDate dateDeNaissance, String motDePasse) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.dateDeNaissance = dateDeNaissance;
		this.motDePasse = motDePasse;
	}
	
	public Client(Droit droit, String nom, String prenom, String adresse, String telephone, String email, LocalDate dateDeNaissance, String motDePasse) {
		this.droit = droit;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.dateDeNaissance = dateDeNaissance;
		this.motDePasse = motDePasse;
	}
	
	public Integer getIdclient() {
		return idclient;
	}

	public void setIdclient(Integer idclient) {
		this.idclient = idclient;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(LocalDate date) {
		this.dateDeNaissance = date;
	}
	
	@Override
	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public Droit getiddroit() {
		return droit;
	}

	public void setiddroit(Droit droit) {
		this.droit = droit;
	}
	
	@Override
	public String getIdentifiant() {
		return email;
	}
}
