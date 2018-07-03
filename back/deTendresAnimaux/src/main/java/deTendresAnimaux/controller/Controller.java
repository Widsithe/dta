package deTendresAnimaux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import deTendresAnimaux.bdd.Admin;
import deTendresAnimaux.bdd.Client;
import deTendresAnimaux.dao.AdminDao;



@RestController
@RequestMapping("/index")
public class Controller {
	
	@Autowired
	AdminDao adminDao;
	
	
	@PreAuthorize(value = "hasAuthority('READ')")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Client display() {
		
		return new Client();
	}
	
	@PreAuthorize(value = "hasAuthority('WRITE')")
	@RequestMapping(value = "/admin/", method = RequestMethod.GET)
	public Admin display2() {
		
		return new Admin();
	}

	public Controller() {
		// TODO Auto-generated constructor stub
	}
	
	


}