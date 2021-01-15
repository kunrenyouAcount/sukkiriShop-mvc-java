package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import model.ProductListLogic;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータを取得
		int selectedProductId = Integer.parseInt(request.getParameter("selectedProductId"));
		int selected_count = Integer.parseInt(request.getParameter("selected_count"));
		//その番号に該当する商品をデータベースで検索し、取得
		ProductListLogic bo = new ProductListLogic();
		Product product = bo.getOne(selectedProductId);
		product.setCount(selected_count);

		//カート内の商品の有無によって新規作成か取得かを処理
		HttpSession session = request.getSession();
		List<Product> cart;
		if(session.getAttribute("cart") == null) {
			//初めてカートに入れる場合、カートを新規作成
			cart = new ArrayList<>();
		} else {
			//カートに入れたものがある場合、カート情報を取得
			cart = (List<Product>) session.getAttribute("cart");
		}
		//カートに追加
		cart.add(product);
		//セッションスコープにカートを格納
		session.setAttribute("cart", cart);
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cart.jsp");
		dispatcher.forward(request, response);
	}
}