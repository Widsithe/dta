package deTendresAnimaux.bdd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Admin implements User {
	@Id
	@GeneratedValue
	private Integer idAdmin;
	private String identifiant;
	private String motDePasse;
	@ManyToOne
	private Droit droit;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	public Admin(String identifiant, String mdp) {
		this.identifiant = identifiant;
		this.motDePasse = mdp;
	}

	public Admin(String identifiant, String mdp, Droit droit) {
		this.identifiant = identifiant;
		this.motDePasse = mdp;
		this.droit = droit;
	}

	public int getidadmin() {
		return idAdmin;
	}

	public void setidadmin(Integer idadmin) {
		this.idAdmin = idadmin;
	}
	
	@Override
	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	@Override
	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMdp(String mdp) {
		this.motDePasse = mdp;
	}

	public Droit getiddroit() {
		return droit;
	}

	public void setiddroit(Droit droit) {
		this.droit = droit;
	}

}
