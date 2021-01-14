package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import model.ProductListLogic;

@WebServlet("/ProductViewServlet")
public class ProductViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータを取得
		int productId = Integer.parseInt(request.getParameter("selectedProductId"));

		//idで検索をかけて商品情報を取得
		ProductListLogic bo = new ProductListLogic();
		Product product = bo.getOne(productId);

		//取得した商品情報をリクエストスコープに格納
		request.setAttribute("product", product);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productView.jsp");
		dispatcher.forward(request, response);
	}

}
