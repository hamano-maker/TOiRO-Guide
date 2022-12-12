package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Inquiry;

public class InquiryDAO {

	private final static String JDBC_URL ="jdbc:mysql://localhost:3306/toiro_db";
	private final static String DB_USER = "root";
	private final static String DB_PASS = "rootroot";

	public static ArrayList<Inquiry> selectKaiketu() {

		ArrayList<Inquiry> inquiryList = new ArrayList<Inquiry>();

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 全部の情報を取ってきてからGETで何を取るかを指定する
			String sql = "SELECT * FROM inquiry join user on inquiry.user_id = user.user_id where resolution = 1 order by reception_date desc;";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				int inquiry_id = rs.getInt("inquiry_id");
				String inquiry_content = rs.getString("inquiry_content");
				int resolution = rs.getInt("resolution");
				int user_id = rs.getInt("user.user_id");
				String userName = rs.getString("user.name_kanji");
				int guide_company_id = rs.getInt("guide_company_id");
				String memo = rs.getString("memo");
				String reception_date = rs.getString("reception_date");
				String address = rs.getString("user.address");
				String phone_number = rs.getString("user.phone_number");

				Inquiry inquiry = new Inquiry(inquiry_id,inquiry_content,resolution,user_id,userName,
						guide_company_id,memo,reception_date,address,phone_number);
				inquiryList.add(inquiry);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inquiryList;
	}

	public static ArrayList<Inquiry> selectMikaiketu() {

		ArrayList<Inquiry> inquiryList = new ArrayList<Inquiry>();

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 全部の情報を取ってきてからGETで何を取るかを指定する
			String sql = "SELECT * FROM inquiry join user on inquiry.user_id = user.user_id where resolution = 0 order by reception_date desc;";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				int inquiry_id = rs.getInt("inquiry_id");
				String inquiry_content = rs.getString("inquiry_content");
				int resolution = rs.getInt("resolution");
				int user_id = rs.getInt("user.user_id");
				String userName = rs.getString("user.name_kanji");
				int guide_company_id = rs.getInt("guide_company_id");
				String memo = rs.getString("memo");
				String reception_date = rs.getString("reception_date");
				String address = rs.getString("user.address");
				String phone_number = rs.getString("user.phone_number");

				Inquiry inquiry = new Inquiry(inquiry_id,inquiry_content,resolution,user_id,userName,
						guide_company_id,memo,reception_date,address,phone_number);
				inquiryList.add(inquiry);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inquiryList;
	}

	public static Inquiry inquiryDetail(int inquiry_id) {

		Inquiry inquiryDetail = null;

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			String sql = "SELECT * FROM inquiry join user on inquiry.user_id = user.user_id where inquiry_id = ?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, inquiry_id);

			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("inquiry_id");
				String inquiry_content = rs.getString("inquiry_content");
				int resolution = rs.getInt("resolution");
				int user_id = rs.getInt("user.user_id");
				String userName = rs.getString("user.name_kanji");
				int guide_company_id = rs.getInt("guide_company_id");
				String memo = rs.getString("memo");
				String reception_date = rs.getString("reception_date");
				String address = rs.getString("user.address");
				String phone_number = rs.getString("user.phone_number");

				inquiryDetail = new Inquiry(id,inquiry_content,resolution,user_id,userName,
						guide_company_id,memo,reception_date,address,phone_number);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inquiryDetail;
	}

	public static boolean inquiryUpdate(Inquiry inquiry) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
		String sql = "UPDATE inquiry SET memo = ?, resolution = ? where inquiry_id = ?;";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, inquiry.getMemo());
				pStmt.setInt(2, inquiry.getResolution());
				pStmt.setInt(3, inquiry.getInquiry_id());

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

}
