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
import model.ProductRegisterLogic;

@WebServlet("/ProductRegisterServlet")
public class ProductRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションから商品情報を取得
		HttpSession session = request.getSession();
		Product product = (Product) session.getAttribute("product");

		//商品登録を実行
		ProductRegisterLogic bo = new ProductRegisterLogic();
		boolean result = bo.productRegister(product);
		if(result) {
			//登録成功のため、セッションから商品情報を削除
			session.removeAttribute("product");
		}
		//登録結果画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/productRegisterResult.jsp");
		dispatcher.forward(request, response);
	}
}
