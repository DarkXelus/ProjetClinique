package fr.eni.clinique.bll;

public class CheckField {
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
}
