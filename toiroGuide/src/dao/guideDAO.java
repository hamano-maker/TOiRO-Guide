package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Guide;

public class guideDAO {

	private final static String JDBC_URL ="jdbc:mysql://localhost:3306/toiro_db";
	private final static String DB_USER = "root";
	private final static String DB_PASS = "rootroot";

	public static boolean idChack(int guideId) {

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			String sql = "select * from guide where guide_id = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, guideId);

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

	public boolean createGuide(Guide guide) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String sql = "INSERT INTO guide(name_kanji,name_kana,date_of_birth,gender_id) VALUES(?,?,?,?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, guide.getKanjiName());
				pStmt.setString(2, guide.getKanaName());
				pStmt.setString(3, guide.getBirthday());
				pStmt.setInt(4, guide.getGender());

				int rs = pStmt.executeUpdate();
				if(rs != 1){
					return false;
				}

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return false;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
			return true;
	}

	public ArrayList<Guide> selectAll() {

		ArrayList<Guide> guideList = new ArrayList<Guide>();

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			String sql = "SELECT guide_id,name_kanji FROM guide;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name_kanji");
				int id = rs.getInt("guide_id");
				Guide guide = new Guide(id, name);
				guideList.add(guide);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return guideList;
	}

	public static ArrayList<Guide> guideList() {

		ArrayList<Guide> guideList = new ArrayList<Guide>();

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			String sql = "SELECT guide_id,name_kanji,name_kana,date_of_birth,g2.gender_category "
					+ "FROM guide as g1 JOIN gender as g2 ON g1.gender_id = g2.gender_id";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				int guide_id = rs.getInt("guide_id");
				String kanjiName = rs.getString("name_kanji");
				String kanaName = rs.getString("name_kana");
				String birthday = rs.getString("date_of_birth");
				String gender = rs.getString("g2.gender_category");
				Guide guide = new Guide(guide_id,kanjiName,kanaName,birthday,gender);
				guideList.add(guide);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return guideList;
	}

	public static Guide guideDetail(int guide_id) {

		Guide guideDetail = null;

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			String sql = "SELECT guide_id,name_kanji,name_kana,date_of_birth,g2.gender_id,g2.gender_category "
					+ "FROM guide as g1 JOIN gender as g2 ON g1.gender_id = g2.gender_id where guide_id = ?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, guide_id);

			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				int g_id = rs.getInt("guide_id");
				String kanjiName = rs.getString("name_kanji");
				String kanaName = rs.getString("name_kana");
				String birthday = rs.getString("date_of_birth");
				int genderId = rs.getInt("g2.gender_id");
				String gender = rs.getString("g2.gender_category");
				guideDetail = new Guide(g_id,kanjiName,kanaName,birthday,genderId,gender);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return guideDetail;
	}

	public boolean guideUpdate(Guide guide) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
		String sql = "update guide set name_kanji = ?, name_kana =  ?, date_of_birth = ?, gender_id = ? "
				+ "where guide_id = ?;";

				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, guide.getKanjiName());
				pStmt.setString(2, guide.getKanaName());
				pStmt.setString(3, guide.getBirthday());
				pStmt.setInt(4, guide.getGender());
				pStmt.setInt(5, guide.getGuide_id());

				int rs = pStmt.executeUpdate();
				if(rs != 1){
					return false;
				}

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return false;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
			return true;
	}

	public static String guideName(int guide_id) {

		String kanjiName = "";

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			String sql = "SELECT name_kanji FROM guide where guide_id = ?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, guide_id);

			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				kanjiName = rs.getString("name_kanji");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kanjiName;
	}

}
