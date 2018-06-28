package fr.eni.clinique.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.BO.Personnels;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;
import fr.eni.clinique.dal.PersonnelsDAO;

public class PersonnelsManager  {

	PersonnelsDAO daoPersonnels;

	public PersonnelsManager() {
		daoPersonnels = DAOFactory.getPersonnelsDAO();
	}
	
	public void delete(Personnels perso) throws DALException, BLLException
	{
		daoPersonnels.delete(perso);
	}

	public void Create(Personnels perso) throws DALException, BLLException {
		try {
			CheckField.CheckPersoName(perso.getNom());
			CheckField.CheckPersoPassword(perso.getMotPasse());
			CheckField.CheckPersoRole(perso.getRole());

			daoPersonnels.create(perso);

		} catch (DALException | BLLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}

	public List<Personnels> SelectAll() throws DALException, BLLException {
		List<Personnels> lstPersonnels = new ArrayList<Personnels>();
		try {
			lstPersonnels = daoPersonnels.selectAll();
		} catch (DALException | BLLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		return lstPersonnels;
	}
}
