package deTendresAnimaux.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import deTendresAnimaux.bdd.Admin;

@Repository
@Transactional
public class AdminDao {
	private JdbcTemplate jdbcTemplate;

	@PersistenceContext
	private EntityManager entityManager;

	

	public Admin findAdminName(String identifiant) {
		List<Admin> admins = new ArrayList<Admin>();
		Query query = entityManager.createQuery("from Admin where identifiant=?").setParameter(0, identifiant);
		admins = query.getResultList();
		if (admins.size() > 0) {
			return admins.get(0);
		} else {
			return null;

			/*
			 * admins = sessionFactory.getCurrentSession()
			 * .createQuery("from Admin where identifiant=?") .setParameter(0, identifiant)
			 * .list(); if (admins.size() > 0) { return admins.get(0); } else { return null;
			 * }
			 */

		}
	}

}
