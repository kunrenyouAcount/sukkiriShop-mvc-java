package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegisterCheckLogic;
import model.User;

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
		String userID = request.getParameter("userID");
		String userPass = request.getParameter("userPass");
		String userMail = request.getParameter("userMail");
		String userName = request.getParameter("userName");
		String userAddress = request.getParameter("userAddress");

	//バリデーションチェック(サーバーに送られている時点でjavascriptを通さず不正にアクセスされているため、データの入力情報がリセットされた状態でページを返す
	//nullチェック
		if(userID == null || userID.length() < 8) {
			doGet(request, response);
		}
		if(userPass == null || userPass.length() < 8){
			doGet(request, response);
		}
		if(userMail == null || userMail.length() == 0){
			doGet(request, response);
		}
		if(userName == null || userName.length() == 0){
			doGet(request, response);
		}
		if(userAddress == null || userAddress.length() == 0){
			doGet(request, response);
		}

		//処理の実行
		//アカウントクラスにリクエストパラメータで取得したデータを格納し、セッションスコープにデータを保存(登録済みだった場合も入力したデータが消えないように)
		User user = new User(userID, userPass, userMail, userName, userAddress);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);

		//登録済かどうかをロジッククラスを実行し確認
		RegisterCheckLogic bo = new RegisterCheckLogic();
		boolean result = bo.execute(user);

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