package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GenderDAO;
import dao.guideDAO;
import model.Gender;
import model.Guide;
import model.GuideUpdateLogic;

/**
 * Servlet implementation class GuideUpdate
 */
@WebServlet("/GuideUpdate")
public class GuideUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String gid = request.getParameter("guide_id");
	    int guide_id = Integer.parseInt(gid);

	    Guide guideDetail = guideDAO.guideDetail(guide_id);

		// ガイド詳細をリクエストスコープに保存
	    request.setAttribute("guideDetail", guideDetail);

		GenderDAO dao = new GenderDAO();
		// 新しいリストにDAOで取得したリストを入れなおす
		ArrayList<Gender> genderAll = dao.selectAll();

		// 性別リストをリクエストスコープに保存
	      request.setAttribute("genderAll", genderAll);

	    // ガイド編集画面にフォワード
	    RequestDispatcher dispatcher = request.getRequestDispatcher
	            ("/WEB-INF/view/GuideUpdate.jsp");
	    dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String gid = request.getParameter("guide_id");
	    int guide_id = Integer.parseInt(gid);
	    String guideNameKanji = request.getParameter("guideNameKanji");
	    String guideNameKana = request.getParameter("guideNameKana");
	    String date_of_birth = request.getParameter("date_of_birth");
	    String gen = request.getParameter("genderId");
	    int genderId = Integer.parseInt(gen);

	    Guide guide = new Guide(guide_id, guideNameKanji, guideNameKana,date_of_birth, genderId);

	    // ガイドアップデートの処理
	    GuideUpdateLogic GuideUpdateLogic = new GuideUpdateLogic();
	    boolean isUpdate = GuideUpdateLogic.guideUp(guide);

	    // ガイドアップデート成功時の処理
	    if (isUpdate) {
		    Guide guideDetail = guideDAO.guideDetail(guide_id);
			// ガイド詳細をリクエストスコープに保存
		    request.setAttribute("guideDetail", guideDetail);

		    RequestDispatcher dispatcher = request.getRequestDispatcher
		            ("/WEB-INF/view/GuideDetail.jsp");
		    dispatcher.forward(request, response);
		// プランアップデート失敗時の処理
	    }else {
		    RequestDispatcher dispatcher = request.getRequestDispatcher
		            ("/WEB-INF/view/GuideDetail.jsp");
		    dispatcher.forward(request, response);
	    }

	}

}
