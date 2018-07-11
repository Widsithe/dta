package deTendresAnimaux.application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import deTendresAnimaux.bdd.Commande;
import deTendresAnimaux.bdd.Produit;
import deTendresAnimaux.bdd.Quantite;
import deTendresAnimaux.bdd.User_;

@RestController
@RequestMapping("/test/")
public class Main {

	@PersistenceContext
	private EntityManager em;

	@RequestMapping("db")
	@Transactional
	public void start() {
		// public static void main(String[] args)

		// Droit droit1=new Droit("Admin");
//		Droit droit2 = new Droit("Client");
//		List<Droit> droits = new ArrayList<>();

		// droits.add(droit1);
//		droits.add(droit2);
		// Admin adiministrateur1=new Admin("admin","admin", droit1);
		//Droit droit1=new Droit("admin");
		
		User_  user1 = new User_ ("Durand", "Pierre", "rue", "0600000", "email1", LocalDate.of(2018, 12, 12), "mdp1");
		User_ user2 = new User_("Bon", "Jean", "impasse du projet", "00000", "email", LocalDate.of(2018, 12, 12), "mdp");
		
		Produit produit = new Produit("mammal", "tigre", 33.0, 22, "////", "Rien du tout", true);
		Produit produit2 = new Produit("mammal", "dromadaire", 33.0, 22, "////", "Rien du tout", true);
		Produit produit3 = new Produit("mammal", "vache", 33.0, 22, "////", "Rien du tout", true);
		Produit produit4 = new Produit("mammal", "elephant", 33.0, 22, "////", "Rien du tout", true);
		Produit produit5 = new Produit("mammal", "renard", 33.0, 22, "////", "Rien du tout", true);
		Produit produit6 = new Produit("mammal", "lapin", 33.0, 22, "////", "Rien du tout", true);
		Produit produit7 = new Produit("ave", "corbeau", 33.0, 22, "////", "Rien du tout", true);
		Produit produit8 = new Produit("ave", "aigle", 33.0, 22, "////", "Rien du tout", true);
		
		
		Commande commande = new Commande(LocalDate.of(2018, 12, 12), user1);
		Quantite quantite = new Quantite(commande, produit, 32);
		em.persist(user1);
		em.persist(user2);
		em.persist(commande);
		em.persist(quantite);
		em.persist(produit);
		em.persist(produit2);
		em.persist(produit3);
		em.persist(produit4);
		em.persist(produit5);
		em.persist(produit6);
		em.persist(produit7);
		em.persist(produit8);
	}

}
