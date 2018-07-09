

package deTendresAnimaux.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import deTendresAnimaux.bdd.Produit;
public class ProduitMapper implements RowMapper<Produit>{
	
	public Produit mapRow(ResultSet rs, int rowNum) throws SQLException {
	Produit p = new Produit();
	p.setIdproduit(rs.getInt("idproduit"));
	p.setNom(rs.getString("active"));
    p.setDescription(rs.getString("description"));
	p.setImage(rs.getString("image"));
    p.setNom(rs.getString("nom"));
	p.setPrix(rs.getDouble("prix"));
	p.setStock(rs.getInt("stock"));
    p.setType(rs.getString("type"));
	return p;
	}
	
}


