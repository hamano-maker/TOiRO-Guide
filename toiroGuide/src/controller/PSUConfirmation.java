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
import shared.Check;

/**
 * Servlet implementation class PSUConfirmation
 */
@WebServlet("/PSUConfirmation")
public class PSUConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String planName = request.getParameter("planName");
	    String planContent = request.getParameter("planContent");
	    String p = request.getParameter("place");
	    String m = request.getParameter("money");
	    String n = request.getParameter("capacity");
	    String g = request.getParameter("guide");

	    boolean result = (!planName.equals("") && planName.length() > 0) &&
	    		(!planContent.equals("") & planContent.length() > 0) &&
	    		Check.isFullNum(m) && Check.isFullNum(n) &&
	    		(Check.isFullNum(g) && guideDAO.idChack(Integer.parseInt(g))) &&
	    		(Check.isFullNum(p) && PlaceDAO.idChack(Integer.parseInt(p)));

	    // resultがfalseだった場合入力画面に戻す
	    if(!result) {

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

	    	RequestDispatcher dispatcher = request.getRequestDispatcher
		            ("/WEB-INF/view/planSignUp.jsp");
		    dispatcher.forward(request, response);
	    }

	    int place = Integer.parseInt(p);
	    int money = Integer.parseInt(m);
	    int capacity = Integer.parseInt(n);
	    int guide = Integer.parseInt(g);

	    String gName = guideDAO.guideName(guide);

	    Plan plan = new Plan(planName,planContent,place,money,capacity,guide,gName);
		// プラン新規登録情報をリクエストスコープに保存
	      request.setAttribute("plan", plan);

		    RequestDispatcher dispatcher = request.getRequestDispatcher
		            ("/WEB-INF/view/PSUConfirmation.jsp");
		    dispatcher.forward(request, response);

	}

}
