package deTendresAnimaux.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import deTendresAnimaux.bdd.Admin;

@Repository
@Transactional
public class AdminDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Admin findAdminName(String identifiant) {
		TypedQuery<Admin> query = entityManager.createQuery("from Admin a where a.identifiant = :idAdmin", Admin.class);
		query.setParameter("idAdmin", identifiant);
		Admin admin = query.getSingleResult();
		System.err.println("dans le dao "+admin.getIdentifiant());
			return admin;

	}

}
