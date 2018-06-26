package fr.eni.clinique.bll;

public class CheckField {
	public static void CheckPersoName(String name) throws BLLException {
		if (name.length() > 30) {
			throw new BLLException("Le nom est trop long(" + name.length() + ") il est limité a 30 catacteres");
		}
	}

	public static void CheckPersoPassword(String Password) throws BLLException {
		if (Password.length() > 10) {
			throw new BLLException(
					"Le mot de passe est trop long(" + Password.length() + ") il est limité a 10 catacteres");
		}
	}

	public static void CheckPersoRole(String role) throws BLLException {
		if (role.length() > 3) {
			throw new BLLException("Le role est trop long(" + role.length() + ") il est limité a 3 catacteres");
		}
	}
}
