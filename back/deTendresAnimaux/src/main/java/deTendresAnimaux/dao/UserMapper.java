package deTendresAnimaux.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import deTendresAnimaux.bdd.User_;

public class UserMapper implements RowMapper<User_> {

	@Override
	public User_ mapRow(ResultSet rs, int rowNum) throws SQLException {
		User_ u = new User_();
		u.setIduser(rs.getInt("iduser"));
		u.setEmail(rs.getString("email"));
		u.setNom(rs.getString("nom"));
		u.setPrenom(rs.getString("prenom"));
		u.setDateDeNaissance(rs.getDate("dateDeNaissance").toLocalDate());    //localdate
		u.setMotDePasse(rs.getString("motDePasse"));
		u.setTelephone(rs.getString("telephone"));
		u.setAdresse(rs.getString("adresse"));

		
		return u;
	}
	


}
