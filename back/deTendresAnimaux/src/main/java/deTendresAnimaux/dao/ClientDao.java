package deTendresAnimaux.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import deTendresAnimaux.bdd.Client;

@Repository
@Transactional
public class ClientDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public Client findClientName(String email) {
		List<Client> clients = new ArrayList<Client>();
		clients = sessionFactory.getCurrentSession().createQuery("from Admin where identifiant=?") .setParameter(0, email).list(); 
		if (clients.size() > 0) {
			return clients.get(0);
		} else {
			return null;
		}

	}


}