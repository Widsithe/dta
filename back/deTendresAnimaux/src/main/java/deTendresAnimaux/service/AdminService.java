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
	
	public List<Produit> getProduits(String name, String type,Integer ref) {
		return produit.findProduits(name,type,ref);
	}

/*	public Produit save(Produit p) {
		return produit.save(p);
	}
	*/
	
	
	public List<Produit> activate() {
		//Produit p = this.get(prodid);
		//if(p==null) 
			return produit.statutProduits("iphone");
	}


}
