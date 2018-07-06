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
	// recuperer tous les produits
	public List<Produit> listeProduits(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "referenceProduit", required = false) Integer referenceProduit) {

		List<Produit> produit = new ArrayList<>();
		produit = (adminService.getProduits(name, type, referenceProduit));
		return produit;

	}

	@GetMapping(value = "CreerProduits", produces = MediaType.APPLICATION_JSON_VALUE)
	public Boolean addProduct(@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "prix", required = true) Double prix,
			@RequestParam(value = "stock", required = true) Integer stock,
			@RequestParam(value = "description", required = true) String description,
			@RequestParam(value = "photo", required = true) String photo,
			@RequestParam(value = "statut", required = true) Boolean statut) {

		Boolean resultat;
		Produit produit;
		produit = new Produit(type, name, prix, stock, photo, description, statut);
		resultat = adminService.ajouterProduits(produit);
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
			@RequestParam(value = "statut", required = true) Boolean statut) {
		Boolean resultat;
		resultat = adminService.modifierProduits(referenceProduit, type, name, prix, stock, photo, description, statut);
		return resultat;

	}

	
	
	@GetMapping(value = "/statut", produces = MediaType.APPLICATION_JSON_VALUE)
	public  Boolean statut(@RequestParam(value = "referenceProduit", required = true) Integer referenceProduit,
				@RequestParam(value = "name", required = false) String name,
				@RequestParam(value = "type", required = false) String type,
				@RequestParam(value = "prix", required = false) Double prix,
				@RequestParam(value = "stock", required = false) Integer stock,
				@RequestParam(value = "description", required = false) String description,
				@RequestParam(value = "photo", required = false) String photo,
				@RequestParam(value = "statut", required = true) Boolean statut) {
		Boolean resultat;
		resultat = adminService.statProduit(referenceProduit, type, name, prix, stock, photo, description, statut);
		return resultat;

		


		}
	
	@GetMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public  Boolean update(@RequestParam(value = "referenceProduit", required = true) Integer referenceProduit,
				//@RequestParam(value = "name", required = false) String name,
				//@RequestParam(value = "type", required = false) String type,
				//@RequestParam(value = "prix", required = false) Double prix,
				//@RequestParam(value = "stock", required = false) Integer stock,
				//@RequestParam(value = "description", required = false) String description,
				//@RequestParam(value = "photo", required = false) String photo,
				@RequestParam(value = "statut", required = true) Boolean statut) {
		Boolean resultat;
		resultat = adminService.up(referenceProduit, statut);
		return resultat;

		


		}

}
