package deTendresAnimaux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import deTendresAnimaux.bdd.Client;
import deTendresAnimaux.dao.UserDao;



@RestController
@RequestMapping("/index")
public class ClientController {
	
	@Autowired
	UserDao userDao;
	@PreAuthorize(value = "hasAuthority('READ')")
	@RequestMapping(method = RequestMethod.GET)
	public Client display() {
		
		return new Client();
	}

	public ClientController() {
		// TODO Auto-generated constructor stub
	}
	
	


}