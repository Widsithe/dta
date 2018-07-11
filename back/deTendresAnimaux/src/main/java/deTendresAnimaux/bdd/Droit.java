package deTendresAnimaux.bdd;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Droit {

	@Id
	@GeneratedValue
	private Integer idDroit;
	private String nomDroit;
	
	
	@OneToMany(mappedBy = "droit")
	private List<User_ > droits;
	
	public Droit() {
	}

	public Droit(String nomDroit) {
		this.nomDroit = nomDroit;
	}



	public String getNomDroit() {
		return nomDroit;
	}

	public void setNomDroit(String nomDroit) {
		this.nomDroit = nomDroit;
	}

	public Integer getIdDroit() {
		return idDroit;
	}

	public void setIdDroit(Integer idDroit) {
		this.idDroit = idDroit;
	}

	// public Droit(String nomdroit, Integer iddroit, List<Admin> listedroits) {
	//
	// this.nomdroit = nomdroit;
	// this.iddroit = iddroit;
	// this.listedroits = listedroits;
	// }
}
