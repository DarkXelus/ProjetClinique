package fr.eni.clinique.BO;

public class Animaux {
	//recid
	Long CodeAnimal;
	//size 30
	String NomAnimal;
	Sex Sexe;//	M:male ; F:femelle ; H:hermaphrodite
	//size 20
	String Couleur;
	//size 20
	String Race;
	//size 20
	String Espece;
	//size 10
	String Tatouage;
	String Antecedents;
	Boolean Archive;
	
	Long CodeClients;
	
	
	
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



	public enum Sex 
	{
	  M,
	  F,
	  H;	
	}
}

