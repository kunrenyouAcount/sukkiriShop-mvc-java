package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BusinessLogin;
import model.LoginLogic;

@WebServlet("/BusinessLoginServlet")
public class BusinessLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログインフォーム画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/businessLoginForm.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String businessID = request.getParameter("businessID");
		String businessPass = request.getParameter("businessPass");

		//ログインクラスに上記で取得したデータを格納し、ロジッククラスを実行
		BusinessLogin businessLogin = new BusinessLogin(businessID, businessPass);
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(businessLogin);

		//その結果によって処理を分岐
		if(result) {
			//ログイン成功時
			//セッションスコープにユーザーIDを保存
			HttpSession session = request.getSession();
			session.setAttribute("businessID", businessID);
		}
		//ログイン結果画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/businessLoginResult.jsp");
		dispatcher.forward(request, response);
	}
}