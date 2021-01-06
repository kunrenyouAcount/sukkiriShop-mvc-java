package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.RegisterCheckLogic;

@WebServlet("/RegisterFormServlet")
public class RegisterFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//登録フォームにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerForm.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメーターの受け取り
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));

		if(userId == null || userId.length() == 0) {
			response.sendRedirect("/sukkiriShop/RegisterFormServlet");
		}

		//処理の実行
		//アカウントクラスにリクエストパラメータで取得したデータを格納し、セッションスコープにデータを保存(登録済みだった場合も入力したデータが消えないように)
		Account account = new Account(userId, pass, mail, name, age);
		HttpSession session = request.getSession();
		session.setAttribute("account", account);

		//登録済かどうかをロジッククラスを実行し確認
		RegisterCheckLogic bo = new RegisterCheckLogic();
		boolean result = bo.execute(account);

		RequestDispatcher dispatcher;

		if(result) {
			//登録済みだった場合フォーム画面をフォワード先に設定
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerForm.jsp");
		} else {
			//未登録の場合、登録可能なので確認画面をフォワード先に設定
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/check.jsp");
		}
		//フォワード
		dispatcher.forward(request, response);
	}
}