package deTendresAnimaux.bdd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Admin {
	@Id
	@GeneratedValue
	private Integer idAdmin;
	private String identifiant;
	private String mdp;
	@ManyToOne
	private Droit droit;

	public Admin(String identifiant, String mdp) {
		this.identifiant = identifiant;
		this.mdp = mdp;
	}

	public Admin(String identifiant, String mdp, Droit droit) {
		this.identifiant = identifiant;
		this.mdp = mdp;
		this.droit = droit;
	}

	public Integer getidadmin() {
		return idAdmin;
	}

	public void setidadmin(Integer idadmin) {
		this.idAdmin = idadmin;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Droit getiddroit() {
		return droit;
	}

	public void setiddroit(Droit droit) {
		this.droit = droit;
	}

	public Admin() {
		// TODO Auto-generated constructor stub
	}

}
