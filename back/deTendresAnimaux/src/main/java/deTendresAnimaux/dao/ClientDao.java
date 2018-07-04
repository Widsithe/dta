package deTendresAnimaux.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import deTendresAnimaux.bdd.Client;

@Repository
@Transactional
public class ClientDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Client findClientByEmail(String email) {
		TypedQuery<Client> query = entityManager.createQuery("from Client c where c.email = :email", Client.class);
		query.setParameter("email", email);

		return query.getSingleResult();
	}

}