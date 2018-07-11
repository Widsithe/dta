package deTendresAnimaux.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import deTendresAnimaux.bdd.Produit;
import deTendresAnimaux.bdd.User_;
import deTendresAnimaux.dao.ProduitDao;
import deTendresAnimaux.dao.UserDao;

@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@Component

public class UserService {
	
	@Autowired
	private ProduitDao produit;
	@Autowired
	private UserDao user;
	
    public List<Produit>  ListerProduit()
    {
    	List<Produit> valeur=new ArrayList<>(); ;
    	valeur =produit.afficherProduitClient();
    	return valeur;
    }
	public List<Produit> getProduitsAfficherClient(String name, String type, Double prixMin, Double prixMax) {
		return produit.findProduitsClient(name, type, prixMin, prixMax);
	}
	

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	public User_ getByUsername(String email) {
		return user.findByUserMail(email);
	}
}


