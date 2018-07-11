package deTendresAnimaux.dao;

import java.util.List;

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
		List<User_> user = query.getResultList();
		if(user.isEmpty()) {
			return null;
		}else {
			return user.get(0);
		}

	}


}
