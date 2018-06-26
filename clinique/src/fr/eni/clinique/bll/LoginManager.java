package fr.eni.clinique.bll;

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
			CheckField.CheckPersoName(name);
			CheckField.CheckPersoPassword(password);

			try {
				role = daoPersonnels.Login(name, password);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return role;
	}

	
}
