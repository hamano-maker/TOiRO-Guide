package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InquiryDAO;
import model.Inquiry;

/**
 * Servlet implementation class InquiryList
 */
@WebServlet("/InquiryList")
public class InquiryList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String resolution = request.getParameter("radiobutton");
	    int resolutionNum = Integer.parseInt(resolution);

		if(resolutionNum == 1) {

			ArrayList<Inquiry> inquiryList = InquiryDAO.selectKaiketu();
			// プラン一覧リストをリクエストスコープに保存
		      request.setAttribute("inquiryList", inquiryList);

		    // お問い合わせ画面にフォワード
		    RequestDispatcher dispatcher = request.getRequestDispatcher
		            ("/WEB-INF/view/InquiryList.jsp");
		    dispatcher.forward(request, response);

		}

		ArrayList<Inquiry> inquiryList = InquiryDAO.selectMikaiketu();
		// プラン一覧リストをリクエストスコープに保存
	      request.setAttribute("inquiryList", inquiryList);

	    // お問い合わせ画面にフォワード
	    RequestDispatcher dispatcher = request.getRequestDispatcher
	            ("/WEB-INF/view/InquiryList.jsp");
	    dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String iId = request.getParameter("radiobutton");
	    int inquiry_id = Integer.parseInt(iId);

	    Inquiry inquiryDetail = InquiryDAO.inquiryDetail(inquiry_id);
		// プラン詳細をリクエストスコープに保存
	    request.setAttribute("inquiryDetail", inquiryDetail);

	    // プラン詳細画面にフォワード
	    RequestDispatcher dispatcher = request.getRequestDispatcher
	            ("/WEB-INF/view/inquiryDetail.jsp");
	    dispatcher.forward(request, response);

	}

}
