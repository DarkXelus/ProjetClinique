package fr.eni.clinique.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.BO.Personnels;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;
import fr.eni.clinique.dal.PersonnelsDAO;

public class PersonnelsManager {

	PersonnelsDAO daoPersonnels;

	public PersonnelsManager() {
		daoPersonnels = DAOFactory.getPersonnelsDAO();
	}

	public void Create(Personnels perso) {
		try {
			CheckField.CheckPersoName(perso.getNom());
			CheckField.CheckPersoPassword(perso.getMotPasse());
			CheckField.CheckPersoRole(perso.getRole());

			try {
				daoPersonnels.create(perso);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Personnels> SelectAll() {
		List<Personnels> lstPersonnels = new ArrayList<Personnels>();
		try {
			lstPersonnels = daoPersonnels.selectAll();
		} catch (DALException | BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstPersonnels;
	}
}
