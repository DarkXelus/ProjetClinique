package fr.eni.clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.BO.Clients;
import fr.eni.clinique.BO.Personnels;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.ClientsDAO;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.JdbcTools;

public class ClientsDAOJdbcImpl implements ClientsDAO {

	private static final String sqlAll = "SELECT * from Clients";
	private static final String sqlCreate = "INSERT INTO Clients(NomClient,PrenomClient,Adresse1,Adresse2,CodePostal,Ville,NumTel,Assurance,Email,Remarque,Archive) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

	// Test connexion a la base de donnée
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
				cli = new Clients(rs.getLong("CodeClient"), rs.getString("NomClient"), rs.getString("PrenomClient"), rs.getString("Adresse1"),
						rs.getString("Adresse2"), rs.getString("CodePostal"), rs.getString("Ville"), rs.getString("NumTel"),
						rs.getString("Assurance"), rs.getString("Email"), rs.getString("Remarque"), rs.getBoolean("Archive"));
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

	@Override
	public Clients read(Long id) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Clients data) throws DALException, BLLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Clients obj) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
