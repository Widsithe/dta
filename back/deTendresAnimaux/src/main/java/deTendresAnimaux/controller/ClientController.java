package deTendresAnimaux.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import deTendresAnimaux.bdd.Produit;
import deTendresAnimaux.security.AuthenticationService;
import deTendresAnimaux.service.AdminService;
import deTendresAnimaux.service.UserService;

@RestController
@RequestMapping("/api/client/")
public class ClientController {
	@Autowired
	private AuthenticationService authenticationService;
	@Autowired
	private UserService userService;
	@GetMapping(value = "AfficherProduit", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Produit> afficherProduct()

	{
  
	 	List<Produit> valeur=new ArrayList<>(); ;
    	valeur =userService.ListerProduit();
    	return valeur;
	}
	
	@GetMapping(value = "produits", produces = MediaType.APPLICATION_JSON_VALUE)
	//recuperer tous les produits
	public List<Produit> listeProduits(
			// rajout pagination sur la recherche
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "nom", required = false) String nom,
			@RequestParam(value = "prixMin", required = false) Double prixMin,
			@RequestParam(value = "prixMax", required = false) Double prixMax,
			@RequestParam(value = "pagination", required = false) Integer pagination) {
		List<Produit> produit = new ArrayList<>();
		produit = (userService.getProduitsAfficherClient(type,nom, prixMin,  prixMax) );
		if (pagination == null) {// quand pagination non mentionn� renvoit tout
			return produit;
		} else if (pagination == 5 && produit.size() >= 5) {
			// renvoit 5 produits
			return produit.subList(0, 5);
		} else if (pagination == 10 && produit.size() >= 10) {
			// renvoit 10 produits
			return produit.subList(0, 10);
		} else if (pagination == 20 && produit.size() >= 20) {
			// renvoit 20 produits
			return produit.subList(0, 20);
		}
		return produit;
	}
	
}
