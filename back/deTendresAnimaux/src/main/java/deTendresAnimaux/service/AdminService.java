package deTendresAnimaux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deTendresAnimaux.bdd.Produit;
import deTendresAnimaux.dao.ProduitDao;

@Component
public class AdminService {
	@Autowired
	private ProduitDao produit;

	public List<Produit> getProduits(String name, String type, Integer ref) {
		return produit.findProduits(name, type, ref);
	}

	public Boolean ajouterProduits(Produit product) {
		Boolean valeur;
		valeur = produit.creerProduit(product);
		return valeur;
	}

	public Boolean modifierProduits(Integer referenceProduit, String type, String name, Double prix, Integer stock,
			String photo, String description, Boolean statut) {
		Boolean valeur;
		valeur = produit.modifierProduit(referenceProduit, type, name, prix, stock, photo, description, statut);
		return valeur;
	}

	public List<Produit> getProduitsAfficher(Integer val) {
		return produit.afficherProduit(val);
	}

	public List<Produit> getProduitsAfficherRecherche(String name, String type, Integer reference, Integer nb) {
		return produit.afficherProduitRecherche(name, type, reference, nb);
	}

	public Boolean statProduit(Integer id, Boolean statut) {
		Boolean valeur;
		valeur = produit.statutProduit(id, statut);
		return valeur;
	}
}
