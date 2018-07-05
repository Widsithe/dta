package deTendresAnimaux.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

	@RequestMapping("/user")
	public Principal getConnectedUser(Principal principal) {
		System.err.println("getConnectedUser");
		return principal;
	}
}
