package deTendresAnimaux.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import deTendresAnimaux.bdd.User_;



@Repository
@Transactional
public class ClientDao {

	@PersistenceContext
	private EntityManager entityManager;

	public User_ findClientByEmail(String email) {
		TypedQuery<User_> query = entityManager.createQuery("from Client c where c.email = :email", User_.class);
		query.setParameter("email", email);

		return query.getSingleResult();
	}

}