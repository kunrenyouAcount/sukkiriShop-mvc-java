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
import model.RegisterCheckLogic;

/**
 * Servlet implementation class BusinessRegisterFormServlet
 */
@WebServlet("/BusinessRegisterFormServlet")
public class BusinessRegisterFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//登録フォームにフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/businessRegisterForm.jsp");
				dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメーターの受け取り
		request.setCharacterEncoding("UTF-8");
		String businessID = request.getParameter("businessID");
		String businessPass = request.getParameter("businessPass");
		String businessMail = request.getParameter("businessMail");
		String businessName = request.getParameter("businessName");

		//バリデーションチェック(サーバーに送られている時点でjavascriptを通さず不正にアクセスされているため、データの入力情報がリセットされた状態でページを返す
		//nullチェック
			if(businessID == null || businessID.length() < 8) {
				doGet(request, response);
			}
			if(businessPass == null || businessPass.length() < 8){
				doGet(request, response);
			}
			if(businessMail == null || businessMail.length() == 0){
				doGet(request, response);
			}
			if(businessName == null || businessName.length() == 0){
				doGet(request, response);
			}

			//処理の実行
			//アカウントクラスにリクエストパラメータで取得したデータを格納し、セッションスコープにデータを保存(登録済みだった場合も入力したデータが消えないように)
			Business business = new Business(businessID, businessPass, businessMail, businessName);
			HttpSession session = request.getSession();
			session.setAttribute("business", business);

			//登録済みかどうかをロジッククラスを実行し確認
			RegisterCheckLogic bo = new RegisterCheckLogic();
			boolean result = bo.checkByBusiness(business);

			RequestDispatcher dispatcher;
			if(result) {
				//登録済みだった場合フォーム画面をフォワード先に設定
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/businessRegisterForm.jsp");
			} else {
				//未登録の場合、登録可能なので確認画面をフォワード先に設定
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/businessRegisterCheck.jsp");
			}
			//フォワード
			dispatcher.forward(request, response);
	}
}
