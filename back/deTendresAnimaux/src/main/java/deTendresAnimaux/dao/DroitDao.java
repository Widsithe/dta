package deTendresAnimaux.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import deTendresAnimaux.bdd.Droit;

@Repository
public class DroitDao { //approledao

	@PersistenceContext
	private EntityManager entityManager;

	public List<String> getRoleNames(Long userId) {
		String sql = "Select ur.appRole.roleName from " + Droit.class.getName() + " ur " //
				+ " where ur.appUser.userId = :userId ";

		Query query = this.entityManager.createQuery(sql, String.class);
		query.setParameter("userId", userId);
		return query.getResultList();

	}
}
