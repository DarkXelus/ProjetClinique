package fr.eni.clinique.BO;

public class Animaux {
	// recid
	Long CodeAnimal;
	// size 30
	String NomAnimal;
	
	Sex Sexe;// M:male ; F:femelle ; H:hermaphrodite
	// size 20
	String Couleur;
	// size 20
	String Race;
	// size 20
	String Espece;
	// size 10
	String Tatouage;
	String Antecedents;
	Boolean Archive;

	Long CodeClients;

	public Long getCodeAnimal() {
		return CodeAnimal;
	}

	public void setCodeAnimal(Long codeAnimal) {
		CodeAnimal = codeAnimal;
	}

	public String getNomAnimal() {
		return NomAnimal;
	}

	public void setNomAnimal(String nomAnimal) {
		NomAnimal = nomAnimal;
	}

	public Sex getSexe() {
		return Sexe;
	}

	public void setSexe(Sex sexe) {
		Sexe = sexe;
	}

	public String getCouleur() {
		return Couleur;
	}

	public void setCouleur(String couleur) {
		Couleur = couleur;
	}

	public String getRace() {
		return Race;
	}

	public void setRace(String race) {
		Race = race;
	}

	public String getEspece() {
		return Espece;
	}

	public void setEspece(String espece) {
		Espece = espece;
	}

	public String getTatouage() {
		return Tatouage;
	}

	public void setTatouage(String tatouage) {
		Tatouage = tatouage;
	}

	public String getAntecedents() {
		return Antecedents;
	}

	public void setAntecedents(String antecedents) {
		Antecedents = antecedents;
	}

	public Boolean getArchive() {
		return Archive;
	}

	public void setArchive(Boolean archive) {
		Archive = archive;
	}

	public Long getCodeClients() {
		return CodeClients;
	}

	public void setCodeClients(Long codeClients) {
		CodeClients = codeClients;
	}

	public Animaux(Long codeAnimal, String nomAnimal, Sex sexe, String couleur, String race, String espece,
			String tatouage, String antecedents, Boolean archive, Long codeClients) {
		super();
		CodeAnimal = codeAnimal;
		NomAnimal = nomAnimal;
		Sexe = sexe;
		Couleur = couleur;
		Race = race;
		Espece = espece;
		Tatouage = tatouage;
		Antecedents = antecedents;
		Archive = archive;
		CodeClients = codeClients;
	}
	
	public Animaux(String nomAnimal, Sex sexe, String couleur, String race, String espece,
			String tatouage, String antecedents, Boolean archive, Long codeClients) {
		super();
		NomAnimal = nomAnimal;
		Sexe = sexe;
		Couleur = couleur;
		Race = race;
		Espece = espece;
		Tatouage = tatouage;
		Antecedents = antecedents;
		Archive = archive;
		CodeClients = codeClients;
	}

	public enum Sex {
		M, F, H;
	}
}
