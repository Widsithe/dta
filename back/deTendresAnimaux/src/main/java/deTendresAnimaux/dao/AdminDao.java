package deTendresAnimaux.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import application.dao.UserRowMapper;
import deTendresAnimaux.bdd.Admin;

@Repository
@Transactional
public class AdminDao {
	private JdbcTemplate jdbcTemplate;



	@Autowired
	private SessionFactory sessionFactory;


	public Admin findAdminName(String identifiant) {
		List<Admin> admins = new ArrayList<Admin>();
		 admins = sessionFactory.getCurrentSession().createQuery("from Admin where identifiant=?") .setParameter(0, identifiant).list(); 
		 if (admins.size() > 0) { 
			 return admins.get(0); 
			 } else { 
				 return null;
				 }

		}


	public Admin getAdminByUsername(String username) {
		AdminMapper rowmap = new AdminMapper();
		return this.jdbcTemplate.queryForObject("select * from users where nickname= ?", new Object[] { username }, rowmap);
	}
	

}
