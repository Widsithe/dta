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
	private User_  client;
	
	
	@ManyToOne
	private User_ user;
	
   
	@OneToMany(mappedBy = "commande")
	private List<Quantite> commande;
	
	public Commande() {
	}

	public Commande(LocalDate dateCommande, User_ user) {
		this.dateCommande = dateCommande;
		this.user = user;
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

	public User_  getClient() {
		return user;
	}

	public void setClient(User_  user) {
		this.user = user;
	}
}
