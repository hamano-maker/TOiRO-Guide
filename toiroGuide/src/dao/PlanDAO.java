package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Plan;

public class PlanDAO {

	private final static String JDBC_URL ="jdbc:mysql://localhost:3306/toiro_db";
	private final static String DB_USER = "root";
	private final static String DB_PASS = "rootroot";

	public boolean createPlan(Plan plan) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
		String sql =
		"INSERT INTO plan(plan_name,plan_content,place_id,money,number_of_people,guide_id) VALUES(?,?,?,?,?,?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, plan.getPlanName());
				pStmt.setString(2, plan.getPlanContent());
				pStmt.setInt(3, plan.getPlace());
				pStmt.setInt(4, plan.getMoney());
				pStmt.setInt(5, plan.getCapacity());
				pStmt.setInt(6, plan.getGuide());

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

	public static ArrayList<Plan> planList() {

		ArrayList<Plan> planList = new ArrayList<Plan>();

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			String sql = "SELECT plan_id,plan_name,p2.place,g.name_kanji\r\n"
					+ "  FROM plan as p1\r\n"
					+ "  JOIN place as p2\r\n"
					+ "  ON p1.place_id = p2.place_id\r\n"
					+ "  JOIN guide as g\r\n"
					+ "  ON p1.guide_id = g.guide_id";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				int plan_id = rs.getInt("plan_id");
				String plan_name = rs.getString("plan_name");
				String place_name = rs.getString("p2.place");
				String name_kanji = rs.getString("g.name_kanji");
				Plan plan = new Plan(plan_id,plan_name,place_name,name_kanji);
				planList.add(plan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return planList;
	}

	public static Plan planDetail(int plan_id) {

		Plan planDetail = null;

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			String sql = "SELECT plan_id,plan_name,plan_content,p2.place_id,p2.place,number_of_people,g.guide_id,g.name_kanji,money "
					+ "FROM plan as p1 JOIN place as p2 ON p1.place_id = p2.place_id "
					+ "JOIN guide as g "
					+ "ON p1.guide_id = g.guide_id "
					+ "where plan_id = ?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, plan_id);

			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				int planId = rs.getInt("plan_id");
				String plan_name = rs.getString("plan_name");
				String plan_content = rs.getString("plan_content");
				int place_id = rs.getInt("p2.place_id");
				String place_name = rs.getString("p2.place");
				int guide_id = rs.getInt("g.guide_id");
				String name_kanji = rs.getString("g.name_kanji");
				int capacity = rs.getInt("number_of_people");
				int money = rs.getInt("money");
				planDetail = new Plan(planId, plan_name, plan_content, place_name, money ,capacity,name_kanji,place_id,guide_id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return planDetail;
	}

	public boolean planUpdate(Plan plan) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
		String sql =
		"UPDATE plan SET plan_name = ?, plan_content = ?, place_id = ?, money = ?, number_of_people = ?, guide_id = ? "
		+ "where plan_id = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, plan.getPlanName());
				pStmt.setString(2, plan.getPlanContent());
				pStmt.setInt(3, plan.getPlace());
				pStmt.setInt(4, plan.getMoney());
				pStmt.setInt(5, plan.getCapacity());
				pStmt.setInt(6, plan.getGuide());
				pStmt.setInt(7, plan.get_Id());

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
