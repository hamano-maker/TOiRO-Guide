package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Guide;
import shared.Check;

/**
 * Servlet implementation class GSUConfirmation
 */
@WebServlet("/GSUConfirmation")
public class GSUConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

	    boolean result = (kanjiName != null && kanjiName.length() > 0) &&
	    		Check.isFullKana(kanaName) && Check.checkDate(birthday) && Check.isGenderNum(gNum);

	    // resultがfalseだった場合入力画面に戻す
	    if(!result) {
	    	RequestDispatcher dispatcher = request.getRequestDispatcher
		            ("/WEB-INF/view/guideSignUp.jsp");
		    dispatcher.forward(request, response);
	    }

	    int gender = Integer.parseInt(gNum);

	    Guide guide = new Guide(kanjiName,kanaName,birthday,gender);
		// ガイド新規登録情報をリクエストスコープに保存
	      request.setAttribute("guide", guide);

		    RequestDispatcher dispatcher = request.getRequestDispatcher
		            ("/WEB-INF/view/GSUConfirmation.jsp");
		    dispatcher.forward(request, response);
	}

}
