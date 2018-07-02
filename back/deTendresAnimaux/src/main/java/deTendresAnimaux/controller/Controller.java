package deTendresAnimaux.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import deTendresAnimaux.dao.UserDao;



@RestController
public class Controller {
	
	@Autowired
	UserDao userDao;
	
	

	   @RequestMapping(value = "/admin", method = RequestMethod.GET)
	    public String adminPage(Model model, Principal principal) {
	         
	        User loginedUser = (User) ((Authentication) principal).getPrincipal();
	 
	        //String userInfo = WebUtils.toString(loginedUser);
	        //model.addAttribute("userInfo", userInfo);
	         
	        return "adminPage";
	    }



	

}
