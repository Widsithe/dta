package deTendresAnimaux.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import deTendresAnimaux.bdd.User_;
import deTendresAnimaux.dao.ClientDao;
import deTendresAnimaux.dao.UserDao;

@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@Component
public class AuthenticationService implements UserDetailsService {




	@Autowired
	private UserDao userDao;

	/*
	 * @Override public UserDetails loadUserByUsername(final String identifiant)
	 * throws UsernameNotFoundException { System.err .println(
	 * "isderubvgiazebvrguizh "+ identifiant);
	 * 
	 * Admin admin = adminDao.findAdminName(identifiant); Set<Droit> droits =
	 * new HashSet<>(); if(admin == null) {
	 * 
	 * Client client = clientDao.findClientByEmail(identifiant);
	 * droits.add(client.getiddroit()); // rajout du droit client ou pas ?
	 * System.err.println("id "+identifiant);
	 * 
	 * }else { droits.add(admin.getiddroit()); System.err.println(
	 * "isderubvgiazebvrguizh on est le else"); }
	 * 
	 * Collection<GrantedAuthority> authorities = buildUserAuthority(droits);
	 * System.err.println(authorities);
	 * 
	 * return buildUserForAuthentication(admin, authorities);
	 * 
	 * }
	 */

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User_ user = userDao.findByUserMail(email);

		if (user != null) {
			List<GrantedAuthority> rules = user.getDroits();
			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getMotDePasse(), rules);
		}

		throw new UsernameNotFoundException("User not found");
	}

	/*
	 * private User buildUserForAuthentication(deTendresAnimaux.bdd.User user,
	 * Collection<GrantedAuthority> authorities) { System.err.println(
	 * "method buildUserForAuthentication : " + authorities); return new
	 * org.springframework.security.core.userdetails.User(user.getIdentifiant(),
	 * user.getMotDePasse(), authorities); }
	 * 
	 * private Collection<GrantedAuthority> buildUserAuthority(Set<Droit>
	 * droits) { Set<GrantedAuthority> setAuths = new HashSet<>();
	 * 
	 * // Build user's authorities for (Droit droit : droits) { setAuths.add(new
	 * SimpleGrantedAuthority(droit.getNomDroit())); }
	 * 
	 * return setAuths; }
	 */
}
