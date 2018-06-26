package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.BO.Personnels;

public interface PersonnelsDAO extends DAO<Personnels> {

	public List<Personnels> selectAll() throws DALException;

	public String Login(String name, String password) throws DALException;
}
