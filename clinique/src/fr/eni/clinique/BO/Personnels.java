package fr.eni.clinique.BO;

public class Personnels {
	Long CodePerso;
	//size 30
	String Nom;
	//size 10
	String MotPasse;
	//size 3	
	String Role ;	
	
	Boolean Archive;

	public Personnels(Long codePerso, String nom, String motPasse, String role, Boolean archive) {
		super();
		CodePerso = codePerso;
		Nom = nom;
		MotPasse = motPasse;
		Role = role;
		Archive = archive;
	}
	//------------------------S'authentifier----------------------
	public String Authentifier(String login,String passsword)
	{
		//methode BDD_authentifier
		return Role;
	}
	//------------------------------------------------------------
}
