package fr.eni.clinique.BO;

import fr.eni.clinique.bll.BLLException;

public class Personnels {
	Long CodePerso;
	// size 30
	String Nom;
	// size 10
	String MotPasse;
	// size 3
	String Role;

	Boolean Archive;

	public Long getCodePerso() {
		return CodePerso;
	}

	public void setCodePerso(Long codePerso) {
		CodePerso = codePerso;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) throws BLLException {
		
		Nom = nom;
	}

	public String getMotPasse() {
		return MotPasse;
	}

	public void setMotPasse(String motPasse) throws BLLException {
		
		MotPasse = motPasse;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) throws BLLException {
		if (role.length() > 3) {
			throw new BLLException("Le role est trop long(" + role.length() + ") il est limité a 3 catacteres");
		}
		Role = role;
	}

	public Boolean getArchive() {
		return Archive;
	}

	public void setArchive(Boolean archive) {
		Archive = archive;
	}

	public Personnels(String nom, String motPasse, String role, Boolean archive ) throws BLLException {
		super();
		this.setNom(nom);
		this.setMotPasse(motPasse);
		this.setRole(role);
		this.setArchive(archive);
	}
	
	
	public Personnels(Long codePerso,String nom, String motPasse, String role, Boolean archive ) throws BLLException {
		super();
		this.setCodePerso(codePerso);
		this.setNom(nom);
		this.setMotPasse(motPasse);
		this.setRole(role);
		this.setArchive(archive);
	}

	@Override
	public String toString() {
		return "Personnels [CodePerso=" + CodePerso + ", Nom=" + Nom + ", MotPasse=" + MotPasse + ", Role=" + Role
				+ ", Archive=" + Archive + "]";
	}

	// ------------------------S'authentifier----------------------
	public String Authentifier(String nom, String passsword) {
		// methode BDD_authentifier
		return Role;
	}
	// ------------------------------------------------------------
}
