package deTendresAnimaux.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deTendresAnimaux.bdd.Produit;
import deTendresAnimaux.dao.ProduitDao;


@Component
public class UserService {
	@Autowired
	private ProduitDao produit;
	
    public List<Produit>  ListerProduit()
    {
    	List<Produit> valeur=new ArrayList<>(); ;
    	valeur =produit.afficherProduitClient();
    	return valeur;
    }
	public List<Produit> getProduitsAfficherClient(String name, String type, Double prixMin, Double prixMax) {
		return produit.findProduitsClient(name, type, prixMin, prixMax);
	}
}
