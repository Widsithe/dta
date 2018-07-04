package deTendresAnimaux.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import deTendresAnimaux.bdd.Admin;
import deTendresAnimaux.dao.AdminDao;

@Service
public class AdminService implements UserDetailsService {
	@Autowired
	private AdminDao adminDao;
	
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("READ"));
		// DEGUEULASSE
		if (username.equals("admin1234")) {
			authorities.add(new SimpleGrantedAuthority("WRITE"));
		}
		// FIN DE DEGUEULASSE
		
		Admin myAdmin = adminDao.findAdminName(username);
		UserDetails myUserDetails = new org.springframework.security.core.userdetails.User(username, myAdmin.getMdp(), authorities);
		return myUserDetails;
	}
}
