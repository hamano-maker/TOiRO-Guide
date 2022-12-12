package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Guide;
import model.GuideSignUpLogic;

/**
 * Servlet implementation class planSignUp
 */
@WebServlet("/guideSignUp")
public class guideSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		PlaceDAO dao = new PlaceDAO();
//		// 新しいリストにDAOで取得したリストを入れなおす
//		ArrayList<Place> placeAll = dao.selectAll();
//
//		// ガイド会社名リストをリクエストスコープに保存
//	      request.setAttribute("placeAll", placeAll);

	    // ガイド新規登録画面にフォワード
	    RequestDispatcher dispatcher = request.getRequestDispatcher
	            ("/WEB-INF/view/guideSignUp.jsp");
	    dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String kanjiName = request.getParameter("kannjiName");
	    String kanaName = request.getParameter("kanaName");
	    String birthday = request.getParameter("date_of_birth");
	    String gNum = request.getParameter("radiobutton");
	    int gender = Integer.parseInt(gNum);

	    Guide guide = new Guide(kanjiName,kanaName,birthday,gender);

	    // 新規登録の処理
	    GuideSignUpLogic guideSignUpLogic = new GuideSignUpLogic();
	    boolean isInsert = guideSignUpLogic.guide(guide);

	    // 新規登録成功時の処理
	    if (isInsert) {
		    RequestDispatcher dispatcher = request.getRequestDispatcher
		            ("/WEB-INF/view/guideSignUp.jsp");
		    dispatcher.forward(request, response);
		// 新規登録失敗時の処理
	    }else {
		    RequestDispatcher dispatcher = request.getRequestDispatcher
		            ("/WEB-INF/view/guideSignUp.jsp");
		    dispatcher.forward(request, response);
	    }

	}

}
