package deTendresAnimaux.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import deTendresAnimaux.bdd.Produit;

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

	public List<Produit> afficherProduit(int val) {
		// pagination affiche les produits avec une limite par page
		List<Produit> produitPagination = new ArrayList<>();
		produitPagination = entityManager.createQuery("SELECT p FROM Produit p").setMaxResults(val).getResultList();
		return produitPagination;
	}

	public List<Produit> afficherProduitRecherche(String name, String type, Integer reference, Integer nb) {
		// pagination affiche les produits avec une limite prenant en compte la
		// recherche
		List<Produit> produitPaginationRecherche = new ArrayList<>();
		produitPaginationRecherche = entityManager
				.createQuery("SELECT p FROM Produit p WHERE p.name = :name "
						+ "AND p.type = :type AND p.reference = :reference ")
				.setParameter("name", name).setParameter("type", type).setParameter("reference", reference)
				.setMaxResults(nb).getResultList();
		return produitPaginationRecherche;
	}

	public Boolean modifierProduit(Integer referenceProduit, String type, String name, Double prix, Integer stock,
			String photo, String description, Boolean statut) {

		Integer identifiantProduit = referenceProduit;
		Produit produit;
		produit = new Produit(referenceProduit, type, name, prix, stock, photo, description, statut);
		// String hqlUpdate = "update produit set produit.active = :active
		// produit.description = :description produit.image = :image,
		// produit.nom=:nom,"
		// + "produit.prix=:prix produit.stock=:stock,produit.type=:type"
		// + " where idproduit = :identifiantProduit";
		//
		// int updatedEntities = entityManager.createQuery(hqlUpdate)
		// .setParameter("active", statut)
		// .setParameter("identifiantProduit", identifiantProduit)
		// .setParameter("description", description)
		// .setParameter("image", photo)
		// .setParameter("nom",name)
		// .setParameter("prix", prix)
		// .setParameter("stock", stock)
		// .setParameter("type", type)
		//
		// .executeUpdate();
		this.jdbcTemplate.update(
				"update produit set active=?,description=?,image=?,nom=?,prix=?,stock=?,type=? where idproduit=?",
				statut, description, photo, name, prix, stock, type, referenceProduit);
		return true;

	}

	public Boolean statutProduit(Integer id, Boolean statut) {
		String SQL = "update produit set active = ? where idproduit = ?";
		jdbcTemplate.update(SQL, statut, id);
		return true;
	}

}
