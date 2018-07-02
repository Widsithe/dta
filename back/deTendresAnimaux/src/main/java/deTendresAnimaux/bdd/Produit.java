package deTendresAnimaux.bdd;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Produit {

	@Id
	@GeneratedValue
	private int idproduit;

	private String Type;

	private String nom;

	private Integer prix;

	private Integer stock;

	private String image;

	private String description;

	private Boolean active; // statut
	
	@OneToMany(mappedBy = "produit")
	private List<Quantite> produit;
	public Produit()
	{
		
	}
	public Produit(String type, String nom, Integer prix, Integer stock, String image, String description,
			Boolean active) {
		super();
		Type = type;
		this.nom = nom;
		this.prix = prix;
		this.stock = stock;
		this.image = image;
		this.description = description;
		this.active = active;
	}

	public Integer getIdproduit() {
		return idproduit;
	}

	public void setIdproduit(Integer idproduit) {
		this.idproduit = idproduit;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getPrix() {
		return prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(int stock) {
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
