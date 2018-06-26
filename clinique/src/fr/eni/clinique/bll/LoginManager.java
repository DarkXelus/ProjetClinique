package fr.eni.clinique.bll;

import fr.eni.clinique.BO.ExceptionPersonnels;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;
import fr.eni.clinique.dal.PersonnelsDAO;

public class LoginManager {

	PersonnelsDAO daoPersonnels;

	public LoginManager() {
		daoPersonnels = DAOFactory.getPersonnelsDAO();
	}

	public String Login(String name, String password) {
		String role = "vide";
		try {
			CheckName(name);
			CheckPassword(password);

			try {
				role = daoPersonnels.Login(name, password);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ExceptionPersonnels e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return role;
	}

	public void CheckName(String name) throws ExceptionPersonnels {
		if (name.length() > 30) {
			throw new ExceptionPersonnels("Le nom est trop long(" + name.length() + ") il est limité a 30 catacteres");
		}
	}

	public void CheckPassword(String Password) throws ExceptionPersonnels {
		if (Password.length() > 10) {
			throw new ExceptionPersonnels(
					"Le mot de passe est trop long(" + Password.length() + ") il est limité a 10 catacteres");
		}
	}
}
