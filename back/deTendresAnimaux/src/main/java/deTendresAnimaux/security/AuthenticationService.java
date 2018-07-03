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
		Admin admin = adminDao.findAdminName(identifiant);
		Client client = clientDao.findClientName(identifiant);

		Set<Droit> droits = new HashSet<>();
		droits.add(admin.getiddroit());
		droits.add(client.getiddroit()); // rajout du droit client ou pas ?
		Collection<GrantedAuthority> authorities = buildUserAuthority(droits);

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

	private User buildUserForAuthentication(Admin admin, Collection<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(admin.getIdentifiant(), admin.getMdp(),
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
