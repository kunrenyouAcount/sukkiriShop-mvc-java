package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegisterLogic;
import model.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションスコープからアカウント情報を取得
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		//データベースに登録処理を行う
		RegisterLogic bo = new RegisterLogic();
		boolean result = bo.registerUser(user);
		if(!result) {
			session.removeAttribute("user");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerResult.jsp");
		dispatcher.forward(request, response);
	}
}
