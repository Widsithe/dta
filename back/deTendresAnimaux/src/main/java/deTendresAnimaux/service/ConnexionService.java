package deTendresAnimaux.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ConnexionService implements UserDetailsService{
	@Override
	public UserDetails loadUserByUsername(String identifiant) throws UsernameNotFoundException {
		return User.builder()
				.username(identifiant)
				.password("password")
				.authorities("READ", "WRITE")
				.build();
	}
}
