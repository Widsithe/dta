package deTendresAnimaux.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import deTendresAnimaux.bdd.Admin;
import deTendresAnimaux.bdd.Client;
import deTendresAnimaux.bdd.Droit;
import deTendresAnimaux.dao.AdminDao;
import deTendresAnimaux.dao.ClientDao;

@Component
public class AuthenticationService implements UserDetailsService {
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private ClientDao clientDao;

	@Override
	public UserDetails loadUserByUsername(final String identifiant) throws UsernameNotFoundException {
		System.err
		.println("isderubvgiazebvrguizh "+ identifiant);
		
		Admin admin = adminDao.findAdminName(identifiant);
		Set<Droit> droits = new HashSet<>();
		if(admin == null) {

				Client client = clientDao.findClientByEmail(identifiant);
				droits.add(client.getiddroit()); // rajout du droit client ou pas ?
				System.err.println("id "+identifiant);
			
		}else {
			droits.add(admin.getiddroit());
			System.err.println("isderubvgiazebvrguizh on est le else");
		}
		
		Collection<GrantedAuthority> authorities = buildUserAuthority(droits);
		System.err.println(authorities);
		
		return buildUserForAuthentication(admin, authorities);
		/*
		 * List<GrantedAuthority> rules = new ArrayList<>(); rules.add(new
		 * SimpleGrantedAuthority("READ"));
		 * 
		 * 
		 * if (username.equals("admin1234")) { rules.add(new
		 * SimpleGrantedAuthority("WRITE")); }
		 * 
		 * Client monClient = userDao.findUserAccount(username); UserDetails
		 * monClientDetails = new
		 * org.springframework.security.core.userdetails.User(username,
		 * monClient.getMotDePasse(), rules); return monClientDetails;
		 */
	}

	private User buildUserForAuthentication(deTendresAnimaux.bdd.User user, Collection<GrantedAuthority> authorities) {
		System.err.println("method buildUserForAuthentication : " + authorities);
		return new org.springframework.security.core.userdetails.User(user.getIdentifiant(), user.getMotDePasse(),
				authorities);
	}

	private Collection<GrantedAuthority> buildUserAuthority(Set<Droit> droits) {
		Set<GrantedAuthority> setAuths = new HashSet<>();

		// Build user's authorities
		for (Droit droit : droits) {
			setAuths.add(new SimpleGrantedAuthority(droit.getNomDroit()));
		}

		return setAuths;
	}
}
