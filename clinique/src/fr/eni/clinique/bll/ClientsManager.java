package fr.eni.clinique.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.BO.Animaux;
import fr.eni.clinique.BO.Clients;
import fr.eni.clinique.dal.ClientsDAO;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;

public class ClientsManager {

	ClientsDAO daoClients;

	public ClientsManager() {
		daoClients = DAOFactory.getClientsDAO();
	}

	public void delete(Clients client) throws DALException, BLLException {
		daoClients.delete(client);
	}

	public void create(Clients cli) throws Exception {
		try {
			CheckField.CheckClientName(cli.getNomClient());
			CheckField.CheckClientPrenom(cli.getPrenomClient());
			CheckField.CheckClientAdresse1(cli.getAdresse1());
			CheckField.CheckClientAdresse2(cli.getAdresse2());
			CheckField.CheckClientCodePostal(cli.getCodePostal());
			CheckField.CheckClientVille(cli.getVille());
			CheckField.CheckClientNumTel(cli.getNumTel());
			CheckField.CheckClientAssurance(cli.getAssurance());
			CheckField.CheckClientEmail(cli.getEmail());
			CheckField.CheckClientRemarque(cli.getRemarque());

			daoClients.create(cli);

		} catch (DALException | BLLException e) {
			throw e;
		}
	}

	public List<Clients> SelectAll() throws DALException, BLLException {
		List<Clients> lstClients = new ArrayList<Clients>();
		try {
			lstClients = daoClients.selectAll();
		} catch (DALException | BLLException e) {
			throw e;
		}
		return lstClients;
	}

	public Long GetID(String nomClient, String prenomClient) throws DALException {
		Long Id = null;
		try {
			Id = daoClients.GetID(nomClient, prenomClient);
		} catch (DALException e) {
			throw e;
		}
		return Id;
	}
	
	public Clients read(Long id) throws DALException, BLLException  {
		Clients cli = new Clients(null, null, null, null, null, null, null, null, null, null, null);
		try {
			cli = daoClients.read(id);
		} catch (DALException e) {
			throw e;
		}
		return cli;
	}
	
	public void update(Clients cli) throws BLLException, DALException {
		try {
			daoClients.update(cli);
		} catch (DALException e) {
			throw e;
		}
	}
	
	public List<Clients> search(String txt) throws DALException, BLLException {
		List<Clients> lstClients = new ArrayList<Clients>();
		try {
			lstClients = daoClients.search(txt);
		} catch (DALException e) {
			throw e;
		}
		return lstClients;
	}
	
	public List<Animaux> selectAnimauxClient(Long codeClient) throws DALException, BLLException {
		List<Animaux> lstAnimaux = new ArrayList<Animaux>();
		try {
			lstAnimaux = daoClients.selectAnimauxClient(codeClient);
		} catch (DALException e) {
			throw e;
		}
		return lstAnimaux;
	}
	
	public Animaux selectAnimal(Long codeAnimal) throws DALException, BLLException {
		Animaux ani = new Animaux(codeAnimal, null, null, null, null, null, null, null, null, null);
		try {
			ani = daoClients.selectAnimal(codeAnimal);
		} catch (DALException e) {
			throw e;
		}
		return ani;
	}
	
	public List<String> selectRaces(String espece) throws DALException, BLLException {
		List<String> lstRaces = new ArrayList<String>();
		try {
			lstRaces = daoClients.selectRaces(espece);
		} catch (DALException e) {
			throw e;
		}
		return lstRaces;	
	}
	
	public void createAnimaux(Animaux data) throws DALException {
		try {
			daoClients.createAnimaux(data);
		} catch (DALException e) {
			throw e;
		}
	}

}
