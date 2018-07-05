package deTendresAnimaux.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import deTendresAnimaux.bdd.Produit;

@Repository
@Transactional
public class ProduitDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<Produit> findProduits(String name, String type, Integer reference) {
		
		// Create CriteriaBuilder
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Produit> query = builder.createQuery(Produit.class);
		
		Root<Produit> rootProduit = query.from(Produit.class);
		
		if (name != null) {
			query.where(builder.equal(rootProduit.get("nom"), name));
		}
		
		if (type != null) {
			query.where(builder.equal(rootProduit.get("type"), type));
		}
		
		if (reference != null) {
			query.where(builder.equal(rootProduit.get("idproduit"), reference));
		}
		
		

		return entityManager.createQuery(query).getResultList();
	}
   
	public Boolean creerProduit(Produit produit)
	{
		Boolean valeur;
		valeur=false;
		try {
		entityManager.persist(produit);
		valeur=true;
		}
		catch(Exception e)
		{
	     valeur= false;
		}
		
		 return valeur;
		
	}
    
}
