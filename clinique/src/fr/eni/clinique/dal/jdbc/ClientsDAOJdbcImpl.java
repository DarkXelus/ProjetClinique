package fr.eni.clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.BO.Clients;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.ClientsDAO;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.JdbcTools;

public class ClientsDAOJdbcImpl implements ClientsDAO {

	private static final String sqlAll = "SELECT * from Clients WHERE Archive= 0";
	private static final String sqlCreate = "INSERT INTO Clients(NomClient,PrenomClient,Adresse1,Adresse2,CodePostal,Ville,NumTel,Assurance,Email,Remarque,Archive) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String sqlRead = "SELECT * from Clients where CodeClient = %1d ";
	private static final String sqlUpdate = "UPDATE Clients SET NomClient = '%1s', PrenomClient = '%2',Adresse1 = '%3',Adresse2 = '%4',CodePostal = '%5',Ville ='%6',Ville = '%7',NumTel ='%8',Assurance = '%9',Email='%10',Remarque ='%11' WHERE Clients.CodeClient = %12";
	private static final String sqlDelete = "UPDATE Clients SET Archive = 'true' WHERE Clients.CodeClient = ? ";
	private static final String sqlId = "SELECT CodeClient from Clients where NomClient = '%1s' AND PrenomClient = '%2s'";


	// Test connexion a la base de donn�e
	public void connexionStatus() throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try {
			cnx = JdbcTools.getConnection();

		} catch (SQLException e) {
			throw new DALException("Connexion failed ");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (rqt != null) {
					rqt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public Clients read(Long id) throws DALException, BLLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Clients cli = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(String.format(sqlRead, id));
			rs = rqt.executeQuery();
			if (rs.next()) {
				cli = new Clients(rs.getString("NomClient"), rs.getString("PrenomClient"), rs.getString("Adresse1"),
						rs.getString("Adresse2"), rs.getString("CodePostal"), rs.getString("Ville"),
						rs.getString("NumTel"), rs.getString("Assurance"), rs.getString("Email"),
						rs.getString("Remarque"), rs.getBoolean("Archive"));
			}

		} catch (SQLException e) {
			throw new DALException("Connexion failed ");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (rqt != null) {
					rqt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cli;
	}

	@Override
	public void update(Clients newdata) throws DALException, BLLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Clients data = read(GetID(newdata.getNomClient(), newdata.getPrenomClient()));

		if (data != null) {
			try {
				cnx = JdbcTools.getConnection();
				rqt = cnx.prepareStatement(String.format(sqlUpdate, newdata.getNomClient(), newdata.getPrenomClient(),
						newdata.getAdresse1(), newdata.getAdresse2(), newdata.getCodePostal(), newdata.getVille(),
						newdata.getNumTel(), newdata.getAssurance(), newdata.getEmail(), newdata.getRemarque(),
						GetID(newdata.getNomClient(), newdata.getPrenomClient())));
				rqt.executeUpdate();

			} catch (SQLException e) {
				throw new DALException("Connexion failed :" + e.getMessage());
			} finally {
				try {
					if (rs != null) {
						rs.close();
					}
					if (rqt != null) {
						rqt.close();
					}
					if (cnx != null) {
						cnx.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public List<Clients> selectAll() throws DALException, BLLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		List<Clients> lstClients = new ArrayList<Clients>();
		Clients cli = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlAll);
			rs = rqt.executeQuery();
			while (rs.next()) {
				cli = new Clients(rs.getLong("CodeClient"), rs.getString("NomClient"), rs.getString("PrenomClient"),
						rs.getString("Adresse1"), rs.getString("Adresse2"), rs.getString("CodePostal"),
						rs.getString("Ville"), rs.getString("NumTel"), rs.getString("Assurance"), rs.getString("Email"),
						rs.getString("Remarque"), rs.getBoolean("Archive"));
				lstClients.add(cli);
			}

		} catch (SQLException e) {
			throw new DALException("Connexion failed :" + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (rqt != null) {
					rqt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lstClients;
	}

	public void create(Clients data) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlCreate);
			rqt.setString(1, data.getNomClient());
			rqt.setString(2, data.getPrenomClient());
			rqt.setString(3, data.getAdresse1());
			rqt.setString(4, data.getAdresse2());
			rqt.setString(5, data.getCodePostal());
			rqt.setString(6, data.getVille());
			rqt.setString(7, data.getNumTel());
			rqt.setString(8, data.getAssurance());
			rqt.setString(9, data.getEmail());
			rqt.setString(10, data.getRemarque());
			rqt.setBoolean(11, data.getArchive());

			rqt.executeUpdate();

		} catch (SQLException e) {
			throw new DALException("Connexion failed :" + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (rqt != null) {
					rqt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Long GetID(String nomClient, String prenomClient) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Long id = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(String.format(sqlId, nomClient, prenomClient));
			rs = rqt.executeQuery();
			if (rs.next()) {
				id = rs.getLong("CodeClient");
			}

		} catch (SQLException e) {
			throw new DALException(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (rqt != null) {
					rqt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return id;
	}

	@Override
	public void delete(Clients obj) throws DALException, BLLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Clients data = read(GetID(obj.getNomClient(), obj.getPrenomClient()));

		if (data != null) {
			try {
				cnx = JdbcTools.getConnection();
				rqt = cnx.prepareStatement(sqlDelete);
				rqt.setLong(1, GetID(obj.getNomClient(), obj.getPrenomClient()));
				rqt.executeUpdate();

			} catch (SQLException e) {
				throw new DALException("Connexion failed :" + e.getMessage());
			} finally {
				try {
					if (rs != null) {
						rs.close();
					}
					if (rqt != null) {
						rqt.close();
					}
					if (cnx != null) {
						cnx.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
