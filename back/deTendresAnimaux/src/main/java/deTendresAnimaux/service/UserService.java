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

package deTendresAnimaux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import deTendresAnimaux.bdd.User_;
import deTendresAnimaux.dao.UserDao;

@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@Component
public class UserService {

	@Autowired
	private UserDao user;

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	public User_ getByUsername(String email) {
		return user.findByUserMail(email);
	}

}
