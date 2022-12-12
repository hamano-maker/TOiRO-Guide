package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Gender;

public class GenderDAO {

	private final static String JDBC_URL ="jdbc:mysql://localhost:3306/toiro_db";
	private final static String DB_USER = "root";
	private final static String DB_PASS = "rootroot";

	public ArrayList<Gender> selectAll() {

		ArrayList<Gender> genderList = new ArrayList<Gender>();

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			String sql = "SELECT * FROM gender;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("gender_id");
				String p = rs.getString("gender_category");
				Gender gender = new Gender(p, id);
				genderList.add(gender);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return genderList;
	}

}
