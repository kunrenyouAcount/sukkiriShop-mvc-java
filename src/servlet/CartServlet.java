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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cart.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cart.jsp");
		//リクエストパラメータを取得
		String productIDString = request.getParameter("productID");
		String selectedCountString = request.getParameter("selectedCount");
		int productID=0;
		int selectedCount=0;

		//IDと選ばれた数がnullの場合一覧に戻す
		if (productIDString == null ||  selectedCountString == null) {
			response.sendRedirect("sukkiriShop/productListServlet");
		} else {
			productID = Integer.parseInt(productIDString);
			selectedCount = Integer.parseInt(selectedCountString);
			if(selectedCount < 1) {
				//数が1より小さい場合はカートに移動
				dispatcher.forward(request, response);
			} else {
				//その番号に該当する商品をデータベースで検索し、取得
				ProductGetLogic bo = new ProductGetLogic();
				Product product = bo.getOne(productID);
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
				dispatcher.forward(request, response);
			}
		}
	}
}