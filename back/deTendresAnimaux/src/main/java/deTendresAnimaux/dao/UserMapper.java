package deTendresAnimaux.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import deTendresAnimaux.bdd.Client;

public class UserMapper implements RowMapper {

	@Override
	public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
		Client c = new Client();
		c.setIdClient(rs.getInt("idclient"));
		c.setEmail(rs.getString("email"));
		c.setNom(rs.getString("nom"));
		c.setPrenom(rs.getString("prenom"));
		c.setDateDeNaissance(rs.getLocalDate("dateDeNaissance"));    //localdate
		c.setMotDePasse(rs.getString("motDePasse"));
		c.setTelephone(rs.getString("telephone"));//string
		c.setAdresse(rs.getString("adresse"));

		
		return c;
	}

}
