package fr.eni.clinique.BO;

public class Clients {
	// recid
	Long CodeClient;
	// size 20
	String NomClient;
	// size 20
	String PrenomClient;

	// size 30
	String Adresse1;
	// size 30
	String Adresse2;
	// size 6
	String CodePostal;
	// size 25
	String Ville;
	// size 15
	String NumTel;
	// size 30
	String Assurance;
	// size 20
	String Email;
	String Remarque;
	Boolean Archive;

	public Long getCodeClient() {
		return CodeClient;
	}

	public void setCodeClient(Long codeClient) {
		CodeClient = codeClient;
	}

	public String getNomClient() {
		return NomClient;
	}

	public void setNomClient(String nomClient) {
		NomClient = nomClient;
	}

	public String getPrenomClient() {
		return PrenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		PrenomClient = prenomClient;
	}

	public String getAdresse1() {
		return Adresse1;
	}

	public void setAdresse1(String adresse1) {
		Adresse1 = adresse1;
	}

	public String getAdresse2() {
		return Adresse2;
	}

	public void setAdresse2(String adresse2) {
		Adresse2 = adresse2;
	}

	public String getCodePostal() {
		return CodePostal;
	}

	public void setCodePostal(String codePostal) {
		CodePostal = codePostal;
	}

	public String getVille() {
		return Ville;
	}

	public void setVille(String ville) {
		Ville = ville;
	}

	public String getNumTel() {
		return NumTel;
	}

	public void setNumTel(String numTel) {
		NumTel = numTel;
	}

	public String getAssurance() {
		return Assurance;
	}

	public void setAssurance(String assurance) {
		Assurance = assurance;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getRemarque() {
		return Remarque;
	}

	public void setRemarque(String remarque) {
		Remarque = remarque;
	}

	public Boolean getArchive() {
		return Archive;
	}

	public void setArchive(Boolean archive) {
		Archive = archive;
	}

	public Clients(Long codeClient, String nomClient, String prenomClient, String adresse1, String adresse2,
			String codePostal, String ville, String numTel, String assurance, String email, String remarque,
			Boolean archive) {
		super();
		CodeClient = codeClient;
		NomClient = nomClient;
		PrenomClient = prenomClient;
		Adresse1 = adresse1;
		Adresse2 = adresse2;
		CodePostal = codePostal;
		Ville = ville;
		NumTel = numTel;
		Assurance = assurance;
		Email = email;
		Remarque = remarque;
		Archive = archive;
	}
	
	public Clients(String nomClient, String prenomClient, String adresse1, String adresse2,
			String codePostal, String ville, String numTel, String assurance, String email, String remarque,
			Boolean archive) {
		super();
		NomClient = nomClient;
		PrenomClient = prenomClient;
		Adresse1 = adresse1;
		Adresse2 = adresse2;
		CodePostal = codePostal;
		Ville = ville;
		NumTel = numTel;
		Assurance = assurance;
		Email = email;
		Remarque = remarque;
		Archive = archive;
	}

}
