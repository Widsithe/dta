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
	
	public List<Produit> getProduits(String name, String type,int ref) {
		return produit.findProduits(name,type,ref);
	}

}
