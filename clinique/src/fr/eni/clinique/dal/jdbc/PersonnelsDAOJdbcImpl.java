package fr.eni.clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.BO.Personnels;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.JdbcTools;
import fr.eni.clinique.dal.PersonnelsDAO;

public class PersonnelsDAOJdbcImpl implements PersonnelsDAO {

	private static final String sqlLogin = "SELECT Role from Personnels where Login ='%1s' AND MotPasse = '%2s'";
	private static final String sqlRead = "SELECT * from Personnels where CodePers = %1d ";
	private static final String sqlAll = "SELECT * from Personnels where Archive = 0";
	private static final String sqlCreate = "INSERT INTO Personnels(Nom,Prenom,Login,MotPasse,Role,Archive) VALUES (?,?,?,?,?,?)";
	private static final String sqlId = "SELECT CodePers from Personnels where Nom = '%1s' AND Prenom = '%2s'";
	private static final String sqlUpdate = "UPDATE Personnels SET Nom = '%1s',MotPasse = '%2',Role = '%3',Archive = '%4' WHERE Personnels.CodePers = %5 ";
	private static final String sqlDelete = "UPDATE Personnels SET Archive = 'true' WHERE Personnels.CodePers = ? ";

	/*public void connexionStatus() throws DALException {
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
	}*/

	@Override
	public String Login(String login, String password) throws DALException, BLLException {

		String role = "vide";
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(String.format(sqlLogin, login, password));
			rs = rqt.executeQuery();
			if (rs.next()) {
				role = rs.getString("Role");
			}
			if (role == "vide") {
				throw new BLLException("Nom ou Mot De Passe incorrect");
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
	public Personnels read(Long id) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Personnels perso = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(String.format(sqlRead, id));
			rs = rqt.executeQuery();
			if (rs.next()) {
				try {
					perso = new Personnels(rs.getString("Nom"), rs.getString("Prenom"), rs.getString("MotPasse"),
							rs.getString("Role"), rs.getBoolean("Archive"));
				} catch (BLLException e) {
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
	public void update(Personnels newdata) throws DALException, BLLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Personnels data = read(GetID(newdata.getNom(), newdata.getPrenom()));

		if (data != null) {
			try {
				cnx = JdbcTools.getConnection();
				rqt = cnx.prepareStatement(String.format(sqlUpdate, newdata.getNom(), newdata.getMotPasse(),
						newdata.getRole(), newdata.getArchive(), GetID(newdata.getNom(), newdata.getPrenom())));
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

	@Override
	public List<Personnels> selectAll() throws DALException, BLLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		List<Personnels> lstPerso = new ArrayList<Personnels>();
		Personnels perso = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlAll);
			rs = rqt.executeQuery();
			while (rs.next()) {
				try {
					perso = new Personnels(rs.getLong("CodePers"), rs.getString("Nom"), rs.getString("Prenom"),
							rs.getString("MotPasse"), rs.getString("Role"), rs.getBoolean("Archive"));
					lstPerso.add(perso);
				} catch (BLLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		return lstPerso;
	}


	@Override
	public void create(Personnels data) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlCreate);
			rqt.setString(1, data.getNom());
			rqt.setString(2, data.getPrenom());
			rqt.setString(3, data.getLogin());
			rqt.setString(4, data.getMotPasse());
			rqt.setString(5, data.getRole());
			rqt.setBoolean(6, data.getArchive());
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

	public Long GetID(String nom, String prenom) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Long id = null;
		try {
 			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(String.format(sqlId, nom, prenom));
			rs = rqt.executeQuery();
			if (rs.next()) {
				id = rs.getLong("CodePers");
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
	public void delete(Personnels obj) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Personnels data = read(GetID(obj.getNom(), obj.getPrenom()));

		if (data != null) {
			try {
				cnx = JdbcTools.getConnection();
				rqt = cnx.prepareStatement(sqlDelete );
				rqt.setLong(1, GetID(obj.getNom(), obj.getPrenom()));
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
