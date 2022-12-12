package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.GuideCompany;

public class LoginDAO {

	private final static String JDBC_URL ="jdbc:mysql://localhost:3306/toiro_db";
	private final static String DB_USER = "root";
	private final static String DB_PASS = "rootroot";

	public GuideCompany findAll(GuideCompany user) {

		GuideCompany userr = null;

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			String sql = "SELECT guide_company_id,pass,company_name FROM guide_company where master_id = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getMaster_id());

			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				int guide_company_id = rs.getInt("guide_company_id");
				String pass = rs.getString("pass");
				String cName = rs.getString("company_name");

				userr = new GuideCompany(guide_company_id,pass, cName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userr;
	}
}
