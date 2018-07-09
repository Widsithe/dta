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
}
