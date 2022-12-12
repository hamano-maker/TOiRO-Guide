package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InquiryDAO;
import model.Inquiry;

/**
 * Servlet implementation class InquiryUpDate
 */
@WebServlet("/InquiryUpDate")
public class InquiryUpDate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String memo = request.getParameter("memo");
	    String id = request.getParameter("inquiry_id");
	    int inquiry_id = Integer.parseInt(id);
	    String r = request.getParameter("radiobutton");
	    int resolution = Integer.parseInt(r);

	    Inquiry inquiry = new Inquiry(memo,resolution,inquiry_id);

	    // 問い合わせ更新の処理
	    boolean isUpdate = InquiryDAO.inquiryUpdate(inquiry);

	    // 問い合わせ更新成功時の処理
	    if (isUpdate) {

		    Inquiry inquiryDetail = InquiryDAO.inquiryDetail(inquiry_id);
			// プラン詳細をリクエストスコープに保存
		    request.setAttribute("inquiryDetail", inquiryDetail);

		    // プラン詳細画面にフォワード
		    RequestDispatcher dispatcher = request.getRequestDispatcher
		            ("/WEB-INF/view/inquiryDetail.jsp");
		    dispatcher.forward(request, response);

		// 問い合わせ更新失敗時の処理
	    }else {
		    RequestDispatcher dispatcher = request.getRequestDispatcher
		            ("/WEB-INF/view/inquiryDetail.jsp");
		    dispatcher.forward(request, response);
	    }

	}

}
