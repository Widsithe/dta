package deTendresAnimaux.bdd;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Commande {
	@Id
	@GeneratedValue
	private Integer idCommande;
	public Commande(LocalDate dateCommande) {
		
		this.dateCommande = dateCommande;
	}

	private LocalDate dateCommande;
	@ManyToOne
	private Client client;
	
	
	@ManyToOne
	private User_ user;
	
   
	@OneToMany(mappedBy = "commande")
	private List<Quantite> commande;
	
	public Commande() {
	}

	public Commande(LocalDate dateCommande, Client client) {
		this.dateCommande = dateCommande;
		this.client = client;
	}

	public Integer getIdCommande() {
		return idCommande;
	}

	public void setIdcommande(Integer idCommande) {
		this.idCommande = idCommande;
	}

	public LocalDate getDateCommande() {
		return dateCommande;
	}

	public void setDatecommande(LocalDate dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
