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
import model.ProductGetLogic;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータを取得
		String selectedProductIDString = request.getParameter("selectedProductID");
		String selectedCountString = request.getParameter("selectedCount");
		int selectedProductID=0;
		int selectedCount=0;

		//IDと数値が正しくない場合には一覧画面に戻す
		if (selectedProductIDString != null) {
			selectedProductID = Integer.parseInt(selectedProductIDString);
		} else {
			response.sendRedirect("/sukkiriShop/ProductListServlet");
		}
		if(selectedCountString != null) {
			selectedCount = Integer.parseInt(selectedCountString);
			if(selectedCount < 1) {
				//数が1より小さい場合も同様に一覧画面に戻す
				response.sendRedirect("/sukkiriShop/ProductListServlet");
			}
		} else {
			response.sendRedirect("/sukkiriShop/ProductListServlet");
		}

		//その番号に該当する商品をデータベースで検索し、取得
		ProductGetLogic bo = new ProductGetLogic();
		Product product = bo.getOne(selectedProductID);
		product.setProductCount(selectedCount);

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