package deTendresAnimaux.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import deTendresAnimaux.bdd.Client;

@Repository
@Transactional
public class UserDao {
	
	@Autowired
	private EntityManager entityManager;

	public Client findUserAccount(String userName) {
		try {
			String sql = "Select e from " + Client.class.getName() + " e " //
					+ " Where e.userName = :userName ";

			Query query = entityManager.createQuery(sql, Client.class);
			query.setParameter("userName", userName);

			return (Client) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
