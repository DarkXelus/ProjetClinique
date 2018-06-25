package fr.eni.clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.JdbcTools;

public class ConnexionDAOJdbcImpl {
	
	private static final String sqlTest = "SELECT * from Clients";
	
	public void connexionStatus() throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;

		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlTest);
			rs = rqt.executeQuery();
		} catch (SQLException e) {
			throw new DALException("Connexion failed ");
		} finally {
			try {
				if (rs != null){
					rs.close();
				}
				if (rqt != null){
					rqt.close();
				}
				if(cnx!=null){
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
	
}
