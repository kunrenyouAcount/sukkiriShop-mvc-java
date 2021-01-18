package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Business;
import model.RegisterLogic;

@WebServlet("/BusinessRegisterServlet")
public class BusinessRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションスコープからアカウント情報を取得
		HttpSession session = request.getSession();
		Business business = (Business) session.getAttribute("business");

		//データベースに登録処理を行う
		RegisterLogic bo = new RegisterLogic();
		boolean result = bo.execute(business);
		if(!result) {
			session.removeAttribute("business");
		}
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/businessRegisterResult.jsp");
		dispatcher.forward(request, response);
	}
}
