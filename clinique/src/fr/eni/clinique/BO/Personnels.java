package fr.eni.clinique.BO;

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

	public void setNom(String nom) throws ExceptionPersonnels {
		if (nom.length() > 30) {
			throw new ExceptionPersonnels("Le nom est trop long(" + nom.length() + ") il est limité a 30 catacteres");
		}
		Nom = nom;
	}

	public String getMotPasse() {
		return MotPasse;
	}

	public void setMotPasse(String motPasse) throws ExceptionPersonnels {
		if (motPasse.length() > 10) {
			throw new ExceptionPersonnels(
					"Le mot de passe est trop long(" + motPasse.length() + ") il est limité a 10 catacteres");
		}
		MotPasse = motPasse;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) throws ExceptionPersonnels {
		if (role.length() > 3) {
			throw new ExceptionPersonnels("Le role est trop long(" + role.length() + ") il est limité a 3 catacteres");
		}
		Role = role;
	}

	public Boolean getArchive() {
		return Archive;
	}

	public void setArchive(Boolean archive) {
		Archive = archive;
	}

	public Personnels(String nom, String motPasse, String role, Boolean archive ) throws ExceptionPersonnels {
		super();
		this.setNom(nom);
		this.setMotPasse(motPasse);
		this.setRole(role);
		this.setArchive(archive);
	}

	// ------------------------S'authentifier----------------------
	public String Authentifier(String nom, String passsword) {
		// methode BDD_authentifier
		return Role;
	}
	// ------------------------------------------------------------
}
