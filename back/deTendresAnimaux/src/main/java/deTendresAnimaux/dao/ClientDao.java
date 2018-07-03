package deTendresAnimaux.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import deTendresAnimaux.bdd.Client;

@Repository
@Transactional
public class ClientDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public Client findClientName(String email) {
		List<Client> clients = new ArrayList<Client>();
		Query query = entityManager.createQuery("from Admin where identifiant=?").setParameter(0, email);
		clients = query.getResultList();
		if (clients.size() > 0) {
			return clients.get(0);
		} else {
			return null;
		}

	}

}