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
		int selectedProductId = Integer.parseInt(request.getParameter("selectedProduct"));

		HttpSession session = request.getSession();
		List<Product> selectedProductList;
		if(session.getAttribute("selectedProductList") == null) {
			//初めてカートに入れる場合
			selectedProductList = new ArrayList<>();
		} else {
			//カートに入れたものがある場合
			selectedProductList = (List<Product>) session.getAttribute("selectedProductList");
		}
		//その番号に該当する商品を検索
		ProductListLogic bo = new ProductListLogic();
		Product product = bo.getOne(selectedProductId);

		//カートに追加
		selectedProductList.add(product);
		session.setAttribute("selectedProductList", selectedProductList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cart.jsp");
		dispatcher.forward(request, response);
	}
}
