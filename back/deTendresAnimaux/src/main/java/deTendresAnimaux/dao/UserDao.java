package deTendresAnimaux.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import deTendresAnimaux.bdd.User_;

@Repository
@Transactional
public class UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	public User_ findByUserMail(String email) {
		TypedQuery<User_> query = entityManager.createQuery("select u from User_ u where email = :email", User_.class);
		query.setParameter("email", email);
		User_ user = query.getSingleResult();
		// System.err.println("dans le dao " + user.getEmail());
		try {
			return query.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}

	}


}
