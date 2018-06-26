package fr.eni.clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.BO.ExceptionPersonnels;
import fr.eni.clinique.BO.Personnels;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.JdbcTools;
import fr.eni.clinique.dal.PersonnelsDAO;

public class PersonnelsDAOJdbcImpl implements PersonnelsDAO {

	private static final String sqlLogin = "SELECT Role from Personnels where Nom ='%1s' AND MotPasse = '%2s'";
	private static final String sqlRead = "SELECT * from Personnels where CodePers = %1d ";
	private static final String sqlAll = "SELECT * from Personnels";
	private static final String sqlCreate = "INSERT INTO Personnels(Nom,MotPasse,Role,Archive) VALUES (%1s,%2s,%3s,%4b)";
	Connection cnx = null;
	PreparedStatement rqt = null;
	ResultSet rs = null;

	public void connexionStatus() throws DALException {

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
	public String Login(String name, String password) throws DALException {

		String role = "vide";

		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(String.format(sqlLogin, name, password));
			rs = rqt.executeQuery();
			if (rs.next()) {
				role = rs.getString("Role");
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
		return role;
	}

	@Override
	public Personnels read(int id) throws DALException {
		Personnels perso = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(String.format(sqlRead, id));
			rs = rqt.executeQuery();
			if (rs.next()) {
				try {
					perso = new Personnels(rs.getString("Nom"), rs.getString("MotPasse"), rs.getString("Role"),
							rs.getBoolean("Archive"));
				} catch (ExceptionPersonnels e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		return perso;
	}

	@Override
	public void update(Personnels data) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Personnels obj) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Personnels> selectAll() throws DALException {
		List<Personnels> lstPerso = new ArrayList<Personnels>();
		Personnels perso = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(String.format(sqlAll));
			rs = rqt.executeQuery();
			if (rs.next()) {
				try {
					perso = new Personnels(rs.getString("Nom"), rs.getString("MotPasse"), rs.getString("Role"),
							rs.getBoolean("Archive"));
					lstPerso.add(perso);
				} catch (ExceptionPersonnels e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		return lstPerso;
	}

	@Override
	public void create(Personnels data) throws DALException {
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(
					String.format(sqlCreate, data.getNom(), data.getMotPasse(), data.getRole(), data.getArchive()));
			rs = rqt.executeQuery();
			

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

}
