package fr.eni.clinique.dal;

import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.clinique.dal.jdbc.PersonnelsDAOJdbcImpl;

public class AppliTestDAL {

	public static void main(String[] args) throws DALException {

		Connection con = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;

		try {
			con = JdbcTools.getConnection();

			rqt = con.prepareStatement("select * from Clients");
			rs = rqt.executeQuery();

			if (rs.next()) {
				System.out.println(rs.getString("NomClient"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
