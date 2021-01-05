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
import model.RegisterLogic;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得(どちらかが必ずnull)
		request.setCharacterEncoding("UTF-8");
		String btn = request.getParameter("btn");
		HttpSession session = request.getSession();

		//セッションスコープからアカウント情報を取得
		Account account = (Account) session.getAttribute("account");

		RequestDispatcher dispatcher = null;
		//登録が押されたパターン
		if(btn.equals("登録")) {
			//データベースに登録処理を行う
			RegisterLogic bo = new RegisterLogic();
			boolean result = bo.execute(account);
			if(result) {
				//登録完了画面を出力
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerOK.jsp");
			} else {
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerNG.jsp");
			}
		//修正が押されたパターン
		} else if(btn.equals("修正")) {
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerForm.jsp");
		}
		dispatcher.forward(request, response);
	}
}
