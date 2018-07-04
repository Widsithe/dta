package deTendresAnimaux.application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import deTendresAnimaux.bdd.Admin;
import deTendresAnimaux.bdd.Client;
import deTendresAnimaux.bdd.Commande;
import deTendresAnimaux.bdd.Droit;
import deTendresAnimaux.bdd.Produit;
import deTendresAnimaux.bdd.Quantite;

@RestController
@RequestMapping("/test/")
public class Main {
	
	@PersistenceContext
	private EntityManager em;
	
	@RequestMapping("db")
	@Transactional
	public void start() {
		Droit droit1=new Droit("Admin");
		Droit droit2=new Droit("Client");
		List<Droit> droits = new ArrayList<>();
		
		droits.add(droit1);
		droits.add(droit2);
		Admin adiministrateur1=new Admin("identifiant","mot de passe", droit1);
		Client client= new Client("eea", "ee","eee", "ee","545", LocalDate.of(2018,12,12),"455") ;
		Produit produit=new Produit("telephone", "iphone", 33, 22, "////","Rien du tout" ,true) ;
		Produit produit2=new Produit("telephone", "samsung", 33, 22, "////","Rien du tout" ,true) ;
		Produit produit3=new Produit("telephone", "samsung", 33, 22, "////","Rien du tout" ,true) ;
		Commande commande=new Commande ( LocalDate.of(2018,12,12),client);
		Quantite quantite=new Quantite(commande,produit,32);
		Quantite quantite2=new Quantite(commande,produit2,33);
		Quantite quantite3=new Quantite(commande,produit3,1);
		em.persist(droit1);
		em.persist(adiministrateur1);
		em.persist(client);
		em.persist(commande);
		em.persist(quantite);
		em.persist(quantite2);
		em.persist(quantite3);
	}

}
