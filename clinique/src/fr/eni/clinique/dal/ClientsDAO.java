package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.BO.Clients;
import fr.eni.clinique.bll.BLLException;

public interface ClientsDAO extends DAO<Clients> {
	
	public List<Clients> selectAll() throws DALException,BLLException;

}
