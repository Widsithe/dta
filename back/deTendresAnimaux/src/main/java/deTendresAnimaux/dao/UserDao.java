package deTendresAnimaux.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import deTendresAnimaux.bdd.User;

@Repository
@Transactional
public class UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	public User findByUserMail(String email) {
		TypedQuery<User> query = entityManager.createQuery("from User u where u.email = :email", User.class);
		query.setParameter("email", email);
		User user = query.getSingleResult();
		// System.err.println("dans le dao " + user.getEmail());
		return user;

	}

}
