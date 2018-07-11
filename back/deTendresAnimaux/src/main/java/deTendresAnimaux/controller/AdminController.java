package deTendresAnimaux.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import deTendresAnimaux.bdd.Produit;
import deTendresAnimaux.security.AuthenticationService;
import deTendresAnimaux.service.AdminService;

@RestController
@RequestMapping("/api/admin/")
public class AdminController {
	@Autowired
	private AuthenticationService authenticationService;
	@Autowired
	private AdminService adminService;


	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public ResponseEntity<String> foo() {
		return new ResponseEntity<String>("Je suis au bout de ma vie!", HttpStatus.OK);
	}

	@GetMapping(value = "produits", produces = MediaType.APPLICATION_JSON_VALUE)
	//recuperer tous les produits
	public List<Produit> listeProduits(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "referenceProduit", required = false) Integer referenceProduit,
			// rajout pagination sur la recherche
			@RequestParam(value = "pagination", required = false) Integer pagination) {
		List<Produit> produit = new ArrayList<>();
		produit = (adminService.getProduits(name, type, referenceProduit));
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

	@GetMapping(value = "AffichageProduits", produces = MediaType.APPLICATION_JSON_VALUE)
	// Afficher un nombre de produit, pagination
	public List<Produit> listeProduitsAfficher(@RequestParam(value = "nb", required = true) Integer nb) {

		List<Produit> produit = new ArrayList<>();
		produit = (adminService.getProduitsAfficherAdmin(nb));
		return produit;

	}
	@GetMapping(value = "CreerProduits", produces = MediaType.APPLICATION_JSON_VALUE)
	public Boolean addProduct(@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "prix", required = true) Double prix, 
	        @RequestParam(value = "stock", required = true) Integer stock,
            @RequestParam(value = "description", required = true) String description,
            @RequestParam(value = "photo", required = true) String photo,
	        @RequestParam(value = "statut", required = true) Boolean statut)
	{

        Boolean resultat;
        Produit produit;
        produit=new Produit(type, name, prix, stock, photo , description, statut);
        resultat=adminService.ajouterProduits(produit);
		return resultat;
		
	}
	
	@GetMapping(value = "ModifierProduit", produces = MediaType.APPLICATION_JSON_VALUE)
	public Boolean updateProduct(@RequestParam(value = "referenceProduit", required = true) Integer referenceProduit,
	@RequestParam(value = "name", required = true) String name,
	@RequestParam(value = "type", required = true) String type,
	@RequestParam(value = "prix", required = true) Double prix, 
    @RequestParam(value = "stock", required = true) Integer stock,
    @RequestParam(value = "description", required = true) String description,
    @RequestParam(value = "photo", required = true) String photo,
    @RequestParam(value = "statut", required = true) Boolean statut)
	{
        Boolean resultat;
        resultat=adminService.modifierProduits(referenceProduit,type,name,prix,stock, photo ,description,statut);
		return resultat;
		
	}
	
	@GetMapping(value = "SupprimerProduit", produces = MediaType.APPLICATION_JSON_VALUE)
	public Boolean deleteProduct(@RequestParam(value = "referenceProduit", required = true) Integer referenceProduit)
//	@RequestParam(value = "name", required = true) String name,
//	@RequestParam(value = "type", required = true) String type,
//	@RequestParam(value = "prix", required = true) Double prix, 
//    @RequestParam(value = "stock", required = true) Integer stock,
//    @RequestParam(value = "description", required = true) String description,
//    @RequestParam(value = "photo", required = true) String photo,
//    @RequestParam(value = "statut", required = true) Boolean statut)
	{
        Boolean resultat;
        resultat=adminService.deleteProduct(referenceProduit);
		return resultat;
		
	}

	@GetMapping(value = "/Statut", produces = MediaType.APPLICATION_JSON_VALUE)
	public Boolean update(@RequestParam(value = "referenceProduit", required = true) Integer referenceProduit,
			@RequestParam(value = "statut", required = true) Boolean statut) {
		Boolean resultat;
		resultat = adminService.statProduit(referenceProduit, statut);
		return resultat;

	}

}
