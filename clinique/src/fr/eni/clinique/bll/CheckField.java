package fr.eni.clinique.bll;

public class CheckField {
	//Check Personnels
	public static void CheckPersoName(String name) throws BLLException {
		if (name.length() > 30) {
			throw new BLLException("Le nom est trop long, il est limité a 30 caractères");
		}
	}

	public static void CheckPersoPassword(String Password) throws BLLException {
		if (Password.length() > 10) {
			throw new BLLException(
					"Le mot de passe est trop long, il est limité a 10 caractères");
		}
	}

	public static void CheckPersoRole(String role) throws BLLException {
		if (role.length() > 3) {
			throw new BLLException("Le role est trop long, il est limité a 3 caractères");
		}
	}

	//Check Clients
	public static void CheckClientName(String name) throws BLLException {
		if (name.length() > 30) {
			throw new BLLException("Le nom est trop long, il est limité a 30 caractères");
		}
	}
	
	public static void CheckClientPrenom(String prenom) throws BLLException {
		if (prenom.length() > 30) {
			throw new BLLException("Le prénom est trop long, il est limité a 30 caractères");
		}
	}
	
	public static void CheckClientAdresse1(String adresse) throws BLLException {
		if(adresse.length() > 80) {
			throw new BLLException("Le prénom est trop long, il est limité a 80 caractères");
		}
	}
	
	public static void CheckClientAdresse2(String adresse) throws BLLException {
		if(adresse.length() > 80) {
			throw new BLLException("Le prénom est trop long, il est limité a 80 caractères");
		}
	}
	
	public static void CheckClientCodePostal(String codepostal) throws BLLException {
		if (codepostal.length() > 5) {
			throw new BLLException("Le code postal est trop long, il est limité a 5 caractères");
		}
	}
	
	public static void CheckClientVille(String ville) throws BLLException {
		if (ville.length() > 50) {
			throw new BLLException("Le code postal est trop long, il est limité a 50 caractères");
		}
	}
	
	public static void CheckClientNumTel(String num) throws BLLException {
		if (num.length() > 10) {
			throw new BLLException("Le numéro de téléphone est trop long, il est limité a 10 caractères");
		}
	}
	
	public static void CheckClientAssurance(String assurance) throws BLLException {
		if (assurance.length() > 30) {
			throw new BLLException("Le nom de l'assurance est trop long, il est limité a 30 caractères");
		}
	}
	
	public static void CheckClientEmail(String email) throws BLLException {
		if (email.length() > 60) {
			throw new BLLException("L'email est trop long, il est limité a 60 caractères");
		}
	}
	
	public static void CheckClientRemarque(String remarque) throws BLLException {
		if (remarque.length() > 60) {
			throw new BLLException("L'email est trop long, il est limité a 60 caractères");
		}
	}
}
