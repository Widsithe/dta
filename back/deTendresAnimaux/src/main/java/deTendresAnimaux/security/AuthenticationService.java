package deTendresAnimaux.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import deTendresAnimaux.bdd.Client;
import deTendresAnimaux.dao.UserDao;

@Component
public class AuthenticationService implements UserDetailsService {
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(final String username) {
		List<GrantedAuthority> rules = new ArrayList<>();
		rules.add(new SimpleGrantedAuthority("READ"));

		
		if (username.equals("admin1234")) {
			rules.add(new SimpleGrantedAuthority("WRITE"));
		}

		Client monClient = userDao.findUserAccount(username);
		UserDetails monClientDetails = new org.springframework.security.core.userdetails.User(username,
				monClient.getMotDePasse(), rules);
		return monClientDetails;
	}
}
