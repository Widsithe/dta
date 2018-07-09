package deTendresAnimaux.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import deTendresAnimaux.bdd.Produit;
import deTendresAnimaux.bdd.Quantite;
@Repository
@Transactional
public class ProduitDao {

	@PersistenceContext
	private EntityManager entityManager;
	private JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	public void stDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

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

	public Boolean creerProduit(Produit produit) {
		Boolean valeur;
		valeur = false;
		try {
			entityManager.persist(produit);
			valeur = true;
		} catch (Exception e) {
			valeur = false;
		}

		return valeur;

	}

	public Boolean modifierProduit(Integer referenceProduit,String type,String name,Double prix,Integer stock,String photo ,String description,Boolean statut) {

		
//		Produit produit;
//		produit=new Produit(referenceProduit,type,name,prix,stock,photo ,description,statut);
//		String hqlUpdate = "update produit set produit.active = :active produit.description = :description  produit.image = :image, produit.nom=:nom,"
//				+ "produit.prix=:prix produit.stock=:stock,produit.type=:type"
//				+ " where idproduit = :identifiantProduit";
//
//		int updatedEntities = entityManager.createQuery(hqlUpdate)
//				.setParameter("active", statut)
//				.setParameter("identifiantProduit", identifiantProduit)
//				.setParameter("description", description)
//				.setParameter("image", photo)
//				.setParameter("nom",name)
//				.setParameter("prix", prix)
//				.setParameter("stock", stock)
//				.setParameter("type", type)
//				
//				.executeUpdate();
	
		this.jdbcTemplate.update("update produit set active=?,description=?,image=?,nom=?,prix=?,stock=?,type=? where idproduit=?"
				,statut,description, photo,name, prix, stock,type,referenceProduit);
	
		return true;
		
	}
	
	public Boolean supprimerProduit(Integer referenceProduit)
	
	{
	    
		
//		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//		CriteriaQuery<Quantite> query = builder.createQuery(Quantite.class);
//
//		Root<Quantite> rootProduit = query.from(Quantite.class);
//		ArrayList<Quantite> resultat = new ArrayList();
//		if (referenceProduit != null) {
//			query.where(builder.equal(rootProduit.get("idproduit"), referenceProduit));
//			
//		}
     
		//resultat=(ArrayList<Quantite>) entityManager.createQuery(query).getResultList();
		//System.out.println(resultat.get(0). +"5555555555555555555555555555555555555555555555555555555555555555555555");
		//System.out.println(this.jdbcTemplate.update("SELECT idproduit from quantite where idproduit=?" ,referenceProduit));
		
		this.jdbcTemplate.update("delete from produit where idproduit=?" ,referenceProduit);
		
	
			//return false;
	
		// INNER JOIN quantite ON quantite.id <> produit.idproduit
		return true;
	}
	public List<Produit>  afficherProduitClient()
	{
		ArrayList<Produit> resultat = new ArrayList<Produit>();
		resultat=(ArrayList<Produit>) this.jdbcTemplate.query("SELECT * from produit where active=true", new ProduitMapper());
		return resultat;
	}
    
	public List<Produit> findProduitsClient(String name, String type, Double Prixmin, Double Prixmax) {

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
}
