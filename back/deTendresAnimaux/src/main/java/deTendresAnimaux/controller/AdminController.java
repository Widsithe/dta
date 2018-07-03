package deTendresAnimaux.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import deTendresAnimaux.service.AdminService;

@RestController
@RequestMapping("/api/admin/")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
//	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
//	public ResponseEntity<String> foo2() {
//		return new ResponseEntity<String>("Ferme la...", HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "hello", method = RequestMethod.GET)
//	public ResponseEntity<String> foo() {
//		return new ResponseEntity<String>(" Je suis au bout de ma vie!", HttpStatus.OK);
//	}
//
//	
//	@GetMapping(value = "utilisateurs", produces = "application/json")
//	public @ResponseBody List<AdminService> getUsers() {
//		//utilisateurService.addUser();
//		return adminService.getUsers();
//	}
//	
//	@PostMapping(value="/", consumes= "application/json")
//	public @ResponseBody void setUser(@RequestBody @Valid AdminService user/*,BindingResult bindingResult*/)
//	{
//		/*System.out.println(bindingResult.getAllErrors());*/
//		adminService.addUser(user);
//	}
//	@DeleteMapping(value="/{id}", consumes= "application/json")
//	public @ResponseBody void supprimerUser(@PathVariable("id") int id)
//	{
//
//		adminService.supprimerUtilisateur( id);
//	}
	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public ResponseEntity<String> foo() {
		return new ResponseEntity<String>(" Je suis au bout de ma vie!", HttpStatus.OK);
	}
	@GetMapping(value="produits/")
	public @ResponseBody  void updateUser( @RequestParam(value="name",required=false)String name, @RequestParam(value="type",required=false)String type, @RequestParam(value="referenceProduit",required=false)String referenceProduit)
	{
		//return new ResponseEntity<String>(" Je suis au bout de ma vie!", HttpStatus.OK);
		System.out.println(name);//adminService.majUtilisateur(id, user);S
	}

}
