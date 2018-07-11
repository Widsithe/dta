package deTendresAnimaux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import deTendresAnimaux.bdd.User_;
import deTendresAnimaux.dao.UserDao;
import deTendresAnimaux.service.AdminService;



@RestController
@RequestMapping("/")
public class Controller {
	
	@Autowired
	UserDao userDao;
	

	
	
	@PreAuthorize(value = "hasAuthority('READ')")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public User_ display() {
		
		return new User_();
	}
	
	@PreAuthorize(value = "hasAuthority('WRITE')")
	@RequestMapping(value = "/admin/", method = RequestMethod.GET)
	public User_ display2() {
		
		return new User_();
	}

	public Controller() {
		// TODO Auto-generated constructor stub
	}
	
	


}