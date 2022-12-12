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
import dao.PlanDAO;
import dao.guideDAO;
import model.Guide;
import model.Place;
import model.Plan;
import model.PlanUpdateLogic;

/**
 * Servlet implementation class PlanUpdate
 */
@WebServlet("/PlanUpdate")
public class PlanUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String pid = request.getParameter("plan_id");
	    int plan_id = Integer.parseInt(pid);

	    Plan planDetail = PlanDAO.planDetail(plan_id);
		// プラン詳細をリクエストスコープに保存
	    request.setAttribute("planDetail", planDetail);

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

	    // プラン詳細画面にフォワード
	    RequestDispatcher dispatcher = request.getRequestDispatcher
	            ("/WEB-INF/view/PlanUpdate.jsp");
	    dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String pid = request.getParameter("plan_id");
	    int plan_id = Integer.parseInt(pid);
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

	    Plan plan = new Plan(plan_id, planName, planContent,place, money, capacity, guide);

	    // プランアップデートの処理
	    PlanUpdateLogic planUpdateLogic = new PlanUpdateLogic();
	    boolean isUpdate = planUpdateLogic.planUp(plan);

	    // プランアップデート成功時の処理
	    if (isUpdate) {
		    Plan planDetail = PlanDAO.planDetail(plan_id);
			// プラン詳細をリクエストスコープに保存
		    request.setAttribute("planDetail", planDetail);

		    RequestDispatcher dispatcher = request.getRequestDispatcher
		            ("/WEB-INF/view/PlanDetail.jsp");
		    dispatcher.forward(request, response);
		// プランアップデート失敗時の処理
	    }else {
		    RequestDispatcher dispatcher = request.getRequestDispatcher
		            ("/WEB-INF/view/PlanDetail.jsp");
		    dispatcher.forward(request, response);
	    }

	}

}
