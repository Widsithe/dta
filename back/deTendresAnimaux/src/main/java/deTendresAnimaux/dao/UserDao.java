package deTendresAnimaux.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import deTendresAnimaux.bdd.Client;

@Repository
@Transactional
public class UserDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private EntityManager entityManager;


	public Client findUserAccount(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
