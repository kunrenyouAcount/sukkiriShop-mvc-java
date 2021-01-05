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

		//処理の実行
		Account account = new Account(userId, pass, mail, name, age);
		RegisterCheckLogic bo = new RegisterCheckLogic();
		boolean result = bo.execute(account);

		//セッションスコープに情報を保存
		HttpSession session = request.getSession();
		session.setAttribute("account", account);

		RequestDispatcher dispatcher;
		//登録済みだった場合
		if(result) {
			//フォワード
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerForm.jsp");
		//未登録の場合、登録可能なので確認画面に遷移
		} else {
			//フォワード
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/checked.jsp");
		}
		dispatcher.forward(request, response);
	}
}
