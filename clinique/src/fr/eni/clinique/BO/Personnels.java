package fr.eni.clinique.BO;

import fr.eni.clinique.bll.BLLException;

public class Personnels {
	Long CodePerso;
	// size 30
	String Nom;
	// size 30
	String Prenom;
	// size 30
	String login;
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

		Role = role;
	}

	public Boolean getArchive() {
		return Archive;
	}

	public void setArchive(Boolean archive) {
		Archive = archive;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Personnels(String nom, String prenom, String motPasse, String role, Boolean archive) throws BLLException {
		super();
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setLogin(String.format("%1s%2s", prenom.substring(0, 1), nom.trim()));
		this.setMotPasse(motPasse);
		this.setRole(role);
		this.setArchive(archive);
	}

	public Personnels(Long codePerso, String nom, String prenom, String motPasse, String role, Boolean archive)
			throws BLLException {
		super();
		this.setCodePerso(codePerso);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setLogin(String.format("%1s%2s", prenom.substring(0, 1), nom.trim()));
		this.setMotPasse(motPasse);
		this.setRole(role);
		this.setArchive(archive);
	}

	@Override
	public String toString() {
		return  Nom + "   " + Prenom + "          "  + Role + "    " +  MotPasse;
	}

}
