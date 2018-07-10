package deTendresAnimaux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deTendresAnimaux.bdd.User_;
import deTendresAnimaux.dao.UserDao;

@Component
public class UserService {
	
	@Autowired
	private UserDao user;
	


	public UserService() {
		// TODO Auto-generated constructor stub
	}


	public User_ getByUsername(String email) {
		return user.findByUserMail(email);
	}

}
