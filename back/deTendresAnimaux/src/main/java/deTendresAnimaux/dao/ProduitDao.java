package deTendresAnimaux.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import deTendresAnimaux.bdd.Produit;

@Repository
@Transactional
public class ProduitDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	Produit produit = new Produit();

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
	
	public boolean statutProduits(int idproduit) {//select produit actif via id et désactive
		TypedQuery<Produit> query =entityManager.createQuery(
				"select p from Produit p where p.idproduit=:idproduit", Produit.class);
		query.setParameter("idproduit", produit.getIdproduit());
		List<Produit> produit = query.getResultList();
		for(Produit prod: produit) {
			if(prod.getActive()==true) {
				prod.setActive(false);
			}else if(prod.getActive()==false) {
				prod.setActive(true);
			}
			
		}
		

		return true;
		
	}

    
}
