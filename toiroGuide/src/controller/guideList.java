package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.guideDAO;
import model.Guide;

/**
 * Servlet implementation class guideList
 */
@WebServlet("/guideList")
public class guideList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Guide> guideList = guideDAO.guideList();
		// プラン一覧リストをリクエストスコープに保存
	      request.setAttribute("guideList", guideList);

		// ガイド一覧画面にフォワード
	    RequestDispatcher dispatcher = request.getRequestDispatcher
	            ("/WEB-INF/view/guideList.jsp");
	    dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String gid = request.getParameter("radiobutton");
	    int guide_id = Integer.parseInt(gid);

	    Guide guideDetail = guideDAO.guideDetail(guide_id);
		// ガイド詳細をリクエストスコープに保存
	    request.setAttribute("guideDetail", guideDetail);

	    // ガイド詳細画面にフォワード
	    RequestDispatcher dispatcher = request.getRequestDispatcher
	            ("/WEB-INF/view/GuideDetail.jsp");
	    dispatcher.forward(request, response);

	}

}
