package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;

@WebServlet("/ProductRegisterFormServlet")
public class ProductRegisterFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//新規登録フォームに画面遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/productRegisterForm.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//リクエストパラメータの取得
		String productName = request.getParameter("productName");
		String productPriceString =  request.getParameter("productPrice");
		String productCountString = request.getParameter("productCount");
		String productDescription = request.getParameter("productDescription");

		//nullチェック
		if(productName == null||productName.length() == 0) {
			doGet(request, response);
		}
		if(productPriceString == null||productPriceString.length() == 0) {
			doGet(request, response);
		}
		if(productCountString == null||productCountString.length() == 0) {
			doGet(request, response);
		}
		if(productDescription == null||productDescription.length() == 0) {
			doGet(request, response);
		}

		int productPrice = Integer.parseInt(productPriceString);
		int productCount = Integer.parseInt(productCountString);

		//正規表現でチェック

		//製品情報をbusinessIDと付随して確認画面で表示する
		HttpSession session = request.getSession();
		String businessID = (String) session.getAttribute("businessID");
		Product product = new Product(productName, productPrice, productCount, productDescription, businessID);
		session.setAttribute("product", product);

		//確認画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/productRegisterCheck.jsp");
		dispatcher.forward(request, response);
	}

}
