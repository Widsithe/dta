package deTendresAnimaux.bdd;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

public class Principale {
	
	public static void main(String[] args) {
		
	EntityManager em = DatabaseHelper.createEntityManager();
	em.getTransaction().begin();
	Droit droit1=new Droit("Admin");
	Droit droit2=new Droit("Client");
	List<Droit> droits = new ArrayList<>();
	
	droits.add(droit1);
	droits.add(droit2);
	Admin adiministrateur1=new Admin("identifiant","mot de passe", droit1);
	Client client= new Client("eea", "ee","eee", "ee","545", LocalDate.of(2018,12,12),"455") ;
	Produit produit=new Produit("telephone", "iphone", 33, 22, "////","Rien du tout" ,true) ;
	Commande commande=new Commande ( LocalDate.of(2018,12,12),client);
	Quantite quantite=new Quantite(commande,produit,32);
	
	em.persist(droit1);
	em.persist(adiministrateur1);
	em.persist(client);
	em.persist(commande);
	em.persist(quantite);
	DatabaseHelper.commitTxAndClose(em);
	System.out.println(adiministrateur1.getidadmin());
	}
}
