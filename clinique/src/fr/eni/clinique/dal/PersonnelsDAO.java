package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.BO.Personnels;
import fr.eni.clinique.bll.BLLException;

public interface PersonnelsDAO extends DAO<Personnels> {

	public List<Personnels> selectAll() throws DALException,BLLException;

	public String Login(String name, String password) throws DALException, BLLException;
	public void create(Personnels perso) throws DALException;
	public void delete(Personnels perso) throws DALException, BLLException;
	public Long GetID(String nom,String prenom) throws DALException;
	public void PasswordUpdate(Personnels newdata) throws DALException, BLLException;
}
