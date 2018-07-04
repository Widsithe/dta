package deTendresAnimaux.controller;

import java.security.Principal;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import deTendresAnimaux.bdd.Produit;
import deTendresAnimaux.dao.ProduitDao;
import deTendresAnimaux.security.AuthenticationService;
import deTendresAnimaux.service.AdminService;

@RestController
@RequestMapping("/api/admin/")
public class AdminController {
	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private AdminService adminService;

	// @RequestMapping(method = RequestMethod.GET, produces = "application/json")
	// public ResponseEntity<String> foo2() {
	// return new ResponseEntity<String>("Ferme la...", HttpStatus.OK);
	// }
	//
	// @RequestMapping(value = "hello", method = RequestMethod.GET)
	// public ResponseEntity<String> foo() {
	// return new ResponseEntity<String>(" Je suis au bout de ma vie!",
	// HttpStatus.OK);
	// }
	//
	//
	// @GetMapping(value = "utilisateurs", produces = "application/json")
	// public @ResponseBody List<AdminService> getUsers() {
	// //utilisateurService.addUser();
	// return adminService.getUsers();
	// }
	//
	// @PostMapping(value="/", consumes= "application/json")
	// public @ResponseBody void setUser(@RequestBody @Valid AdminService
	// user/*,BindingResult bindingResult*/)
	// {
	// /*System.out.println(bindingResult.getAllErrors());*/
	// adminService.addUser(user);
	// }
	// @DeleteMapping(value="/{id}", consumes= "application/json")
	// public @ResponseBody void supprimerUser(@PathVariable("id") int id)
	// {
	//
	// adminService.supprimerUtilisateur( id);
	// }
	@RequestMapping("/logadmin")
	public Principal admin(Principal admin) {
		return admin;
	}

	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public ResponseEntity<String> foo() {
		return new ResponseEntity<String>(" Je suis au bout de ma vie!", HttpStatus.OK);
	}

	@GetMapping(value = "produits", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Produit> updateUser(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "referenceProduit", required = false) Integer referenceProduit) {
		// return new ResponseEntity<String>(" Je suis au bout de ma vie!",
		// HttpStatus.OK);
		// ProduitDao.findProduits(name, type, referenceProduit);
		// ProduitDao produit=new ProduitDao();

		List<Produit> produit = new ArrayList<>();
		produit = (adminService.getProduits(name, type,referenceProduit));
		for (int i = 0; i < produit.size(); i++) {
			System.out.println(
					"gdfggggggggggggggggggggggggggggggggggggggggggggggggggggggggg" + produit.get(i).getIdproduit());
		}
		return produit;
		// System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXX"+
		// name);//adminService.majUtilisateur(id, user);S
		// System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXX" + type);
		// System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXX" +referenceProduit);
		// //System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv"
		// +adminService.getProduits(name,type,referenceProduit));
		// List<Produit>produit = new ArrayList<>();
		// produit=(adminService.getProduits(name,type,referenceProduit));
		// System.out.println("gdfggggggggggggggggggggggggggggggggggggggggggggggggggggggggg"+produit.get(0).getPrix());
	}
	@GetMapping(value = "CreerProduits", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Produit> addProduct(@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "prix", required = true) Integer prix, 
	        @RequestParam(value = "stock", required = true) Integer stock,
            @RequestParam(value = "description", required = true) String description,
            @RequestParam(value = "photo", required = true) String photo,
	        @RequestParam(value = "statut", required = true) Boolean statut)
	{
		// return new ResponseEntity<String>(" Je suis au bout de ma vie!",
		// HttpStatus.OK);
		// ProduitDao.findProduits(name, type, referenceProduit);
		// ProduitDao produit=new ProduitDao();

		List<Produit> produit = new ArrayList<>();
		produit = (adminService.getProduits(name, type,referenceProduit));
		for (int i = 0; i < produit.size(); i++) {
			System.out.println(
					"gdfggggggggggggggggggggggggggggggggggggggggggggggggggggggggg" + produit.get(i).getIdproduit());
		}
		return produit;
		// System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXX"+
		// name);//adminService.majUtilisateur(id, user);S
		// System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXX" + type);
		// System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXX" +referenceProduit);
		// //System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv"
		// +adminService.getProduits(name,type,referenceProduit));
		// List<Produit>produit = new ArrayList<>();
		// produit=(adminService.getProduits(name,type,referenceProduit));
		// System.out.println("gdfggggggggggggggggggggggggggggggggggggggggggggggggggggggggg"+produit.get(0).getPrix());
	}
	
}
