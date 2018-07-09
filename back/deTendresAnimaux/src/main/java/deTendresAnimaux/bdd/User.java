package deTendresAnimaux.bdd;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer iduser;

	@ManyToOne
	private Droit droit;

	private String nom;

	private String prenom;

	private String adresse;

	private String telephone;

	private String email;

	private LocalDate dateDeNaissance;

	private String motDePasse;

	private String role;

	public User() {

	}

	public User(String nom, String prenom, String adresse, String telephone, String email, LocalDate dateDeNaissance,
			String motDePasse) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.dateDeNaissance = dateDeNaissance;
		this.motDePasse = motDePasse;
	}

	public User(Droit droit, String nom, String prenom, String adresse, String telephone, String email,
			LocalDate dateDeNaissance, String motDePasse) {
		this.droit = droit;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.dateDeNaissance = dateDeNaissance;
		this.motDePasse = motDePasse;
	}

	public Integer getIduser() {
		return iduser;
	}

	public void setIduser(Integer iduser) {
		this.iduser = iduser;
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

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public List<GrantedAuthority> getDroits() {
		if (this.role != null && !this.role.isEmpty())
			return Arrays.asList(new SimpleGrantedAuthority(this.role));
		else
			return Arrays.asList();
	}

}
