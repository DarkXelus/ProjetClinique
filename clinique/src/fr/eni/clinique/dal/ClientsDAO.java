package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.BO.Animaux;
import fr.eni.clinique.BO.Clients;
import fr.eni.clinique.bll.BLLException;

public interface ClientsDAO extends DAO<Clients> {
	
	public List<Clients> selectAll() throws DALException,BLLException;
	
	public void create(Clients client) throws DALException;
	
	public void delete(Clients client) throws DALException, BLLException;
	
	public Long GetID(String nomClient,String prenomClient) throws DALException;
	
	public Clients read(Long id) throws DALException, BLLException ;
	
	public void update(Clients client) throws DALException, BLLException ;
	
	public List<Clients> search(String txt) throws DALException, BLLException;
	
	public List<Animaux> selectAnimauxClient(Long codeClient) throws DALException, BLLException;
}
