package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PlanDAO;
import model.Plan;

/**
 * Servlet implementation class planList
 */
@WebServlet("/planList")
public class planList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		ArrayList<Plan> planList = PlanDAO.planList();
		// プラン一覧リストをリクエストスコープに保存
	      request.setAttribute("planList", planList);

	    // プラン一覧画面にフォワード
	    RequestDispatcher dispatcher = request.getRequestDispatcher
	            ("/WEB-INF/view/planList.jsp");
	    dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String pid = request.getParameter("radiobutton");
	    int plan_id = Integer.parseInt(pid);

	    Plan planDetail = PlanDAO.planDetail(plan_id);
		// プラン詳細をリクエストスコープに保存
	    request.setAttribute("planDetail", planDetail);

	    // プラン詳細画面にフォワード
	    RequestDispatcher dispatcher = request.getRequestDispatcher
	            ("/WEB-INF/view/PlanDetail.jsp");
	    dispatcher.forward(request, response);

	}

}
