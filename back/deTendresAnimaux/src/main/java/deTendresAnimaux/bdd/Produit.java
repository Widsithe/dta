package deTendresAnimaux.bdd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produit {

	@Id
	@GeneratedValue
	private Integer idproduit;

	public Produit(Integer idproduit, String type, String nom, Double prix, Integer stock, String image,
			String description, Boolean active) {
		super();
		this.idproduit = idproduit;
		this.type = type;
		this.nom = nom;
		this.prix = prix;
		this.stock = stock;
		this.image = image;
		this.description = description;
		this.active = active;
	}

	public Produit(String type, String nom, Double prix, Integer stock, String image, String description, Boolean active) {
		this.type = type;
		this.nom = nom;
		this.prix = prix;
		this.stock = stock;
		this.image = image;
		this.description = description;
		this.active = active;
	}
	
	public Produit() {
		
	}

	private String type;

	private String nom;

	private Double prix;

	private Integer stock;

	private String image;

	private String description;

	private Boolean active; // statut

	public Integer getIdproduit() {
		return idproduit;
	}

	public void setIdproduit(Integer idproduit) {
		this.idproduit = idproduit;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
