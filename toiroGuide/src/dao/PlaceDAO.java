package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Place;

public class PlaceDAO {

	private final static String JDBC_URL ="jdbc:mysql://localhost:3306/toiro_db";
	private final static String DB_USER = "root";
	private final static String DB_PASS = "rootroot";

	public static boolean idChack(int placeId) {

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			String sql = "select * from place where place_id = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, placeId);

			ResultSet rs = pStmt.executeQuery();
				if(rs.next()){
					return true;
			    }
			    	return false;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<Place> selectAll() {

		ArrayList<Place> placeList = new ArrayList<Place>();

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			String sql = "SELECT * FROM place;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				String p = rs.getString("place");
				int id = rs.getInt("place_id");
				Place place = new Place(id, p);
				placeList.add(place);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return placeList;
	}

}
