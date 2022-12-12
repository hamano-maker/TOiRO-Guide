package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.GuideCompany;

public class guideCompanyDAO {

	private final static String JDBC_URL ="jdbc:mysql://localhost:3306/toiro_db";
	private final static String DB_USER = "root";
	private final static String DB_PASS = "rootroot";

	public ArrayList<GuideCompany> cName () {

		// 空のリストを用意
		ArrayList<GuideCompany> guideCompanyName = new ArrayList<GuideCompany>();

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			String sql = "SELECT company_name FROM guide_company";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				String cName = rs.getString("company_name");
				GuideCompany name = new GuideCompany(cName);
				// リストにセレクトで取得した情報を入れていく
				guideCompanyName.add(name);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return guideCompanyName;
	}

}
