package fr.eni.clinique.bll;

import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;
import fr.eni.clinique.dal.PersonnelsDAO;

public class LoginManager {

	PersonnelsDAO daoPersonnels;

	public LoginManager() {
		daoPersonnels = DAOFactory.getPersonnelsDAO();
	}

	public String Login(String name, String password) throws Exception {
		String role = "vide";
		try {
			CheckField.CheckPersoName(name);
			CheckField.CheckPersoPassword(password);

				role = daoPersonnels.Login(name, password);
			
		} catch (DALException | BLLException e) {
			// TODO Auto-generated catch block
			
				throw e;
		}
		return role;
	}

	
}
