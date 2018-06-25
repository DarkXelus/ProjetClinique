package fr.eni.clinique.BO;

public class Clients {
	// recid
	Long CodeClient;
	//size 20
	String NomClient;
	//size 20
	String PrenomClient;
	
	//size 30
	String Adresse1;
	//size 30
	String Adresse2;
	//size 6
	String CodePostal;
	//size 25
	String Ville;
	//size 15
	String NumTel;
	//size 30
	String Assurance;
	//size 20
	String Email;	
	String Remarque;
	Boolean Archive;
	
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
	
	}
