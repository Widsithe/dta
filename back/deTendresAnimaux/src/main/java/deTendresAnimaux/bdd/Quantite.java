package deTendresAnimaux.bdd;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;	


@Entity
public class Quantite {
	@Id
	@GeneratedValue
	private Integer idquantite;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="idCommande")
	private Commande commande;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="idProduit")
	private Produit produit;
	private Integer quantite;
	
	public Quantite() {
	}
	
	public Quantite (Commande commande, Produit produit, Integer quantite) {
		
		
		this.commande = commande;
		this.produit = produit;
		this.quantite = quantite;
	}
	
	public Integer getIdquantite() {
		return idquantite;
	}
	
	public void setIdquantite(Integer idquantite) {
		this.idquantite = idquantite;
	}
	
	public Commande getCommande() {
		return commande;
	}
	
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	public Produit getProduit() {
		return produit;
	}
	
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	public Integer getQuantite() {
		return quantite;
	}
	
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	
	
}
