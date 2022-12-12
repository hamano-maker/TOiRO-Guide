package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PlaceDAO;
import dao.guideDAO;
import model.Guide;
import model.Place;
import model.Plan;
import model.PlanSignUpLogic;

/**
 * Servlet implementation class planSignUp
 */
@WebServlet("/planSignUp")
public class planSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PlaceDAO dao = new PlaceDAO();
		// 新しいリストにDAOで取得したリストを入れなおす
		ArrayList<Place> placeAll = dao.selectAll();

		guideDAO dao1 = new guideDAO();
		// 新しいリストにDAOで取得したリストを入れなおす
		ArrayList<Guide> guideAll = dao1.selectAll();

		// 場所リストをリクエストスコープに保存
	      request.setAttribute("placeAll", placeAll);
	    // ガイドリストをリクエストスコープに保存
	      request.setAttribute("guideAll", guideAll);

	    // プラン新規登録画面にフォワード
	    RequestDispatcher dispatcher = request.getRequestDispatcher
	            ("/WEB-INF/view/planSignUp.jsp");
	    dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String planName = request.getParameter("planName");
	    String planContent = request.getParameter("planContent");
	    String p = request.getParameter("place");
	    int place = Integer.parseInt(p);
	    String m = request.getParameter("money");
	    int money = Integer.parseInt(m);
	    String n = request.getParameter("capacity");
	    int capacity = Integer.parseInt(n);
	    String g = request.getParameter("guide");
	    int guide = Integer.parseInt(g);

	    Plan plan = new Plan(planName,planContent,place,money,capacity,guide);

	    // 新規登録の処理
	    PlanSignUpLogic planSignUpLogic = new PlanSignUpLogic();
	    boolean isInsert = planSignUpLogic.plan(plan);

	    // 新規登録成功時の処理
	    if (isInsert) {

			PlaceDAO dao = new PlaceDAO();
			// 新しいリストにDAOで取得したリストを入れなおす
			ArrayList<Place> placeAll = dao.selectAll();

			guideDAO dao1 = new guideDAO();
			// 新しいリストにDAOで取得したリストを入れなおす
			ArrayList<Guide> guideAll = dao1.selectAll();

			// 場所リストをリクエストスコープに保存
		      request.setAttribute("placeAll", placeAll);
		    // ガイドリストをリクエストスコープに保存
		      request.setAttribute("guideAll", guideAll);

		    // プラン新規登録画面にフォワード
		    RequestDispatcher dispatcher = request.getRequestDispatcher
		            ("/WEB-INF/view/planSignUp.jsp");
		    dispatcher.forward(request, response);

		// 新規登録失敗時の処理
	    }else {

			PlaceDAO dao = new PlaceDAO();
			// 新しいリストにDAOで取得したリストを入れなおす
			ArrayList<Place> placeAll = dao.selectAll();

			guideDAO dao1 = new guideDAO();
			// 新しいリストにDAOで取得したリストを入れなおす
			ArrayList<Guide> guideAll = dao1.selectAll();

			// 場所リストをリクエストスコープに保存
		      request.setAttribute("placeAll", placeAll);
		    // ガイドリストをリクエストスコープに保存
		      request.setAttribute("guideAll", guideAll);

		    // プラン新規登録画面にフォワード
		    RequestDispatcher dispatcher = request.getRequestDispatcher
		            ("/WEB-INF/view/planSignUp.jsp");
		    dispatcher.forward(request, response);
	    }

	}

}
