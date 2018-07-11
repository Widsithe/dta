package deTendresAnimaux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import deTendresAnimaux.bdd.User_;
import deTendresAnimaux.service.UserService;

@RestController
@RequestMapping("/api/user/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping(value = "/byMail", produces = MediaType.APPLICATION_JSON_VALUE)
	public User_ identifiant(@RequestParam(value = "email", required = true) String email) {
		User_ resultat;
		resultat = userService.getByUsername(email);
		return resultat;

	}
	


}
