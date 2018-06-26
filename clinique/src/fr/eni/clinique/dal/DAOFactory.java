package fr.eni.clinique.dal;

import fr.eni.clinique.dal.jdbc.PersonnelsDAOJdbcImpl;

public class DAOFactory {
	public static PersonnelsDAO getPersonnelsDAO() {
		return new PersonnelsDAOJdbcImpl();
	}
}
