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

	public Client findUserAccount(String userName) {
		return this.jdbcTemplate.queryForObject("select * from usertable where login = ?", new Object[]{ username }, new UserMapper());
	}

}
