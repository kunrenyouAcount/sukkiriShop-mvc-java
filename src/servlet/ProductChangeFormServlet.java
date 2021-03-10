package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Product;
import model.ProductGetLogic;

@WebServlet("/ProductChangeFormServlet")
public class ProductChangeFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの受け取り
		request.setCharacterEncoding("UTF-8");
		String productIDString = request.getParameter("productID");
		RequestDispatcher dispatcher;
		//nullチェック
		if(productIDString == null || productIDString.length() == 0) {
			dispatcher = request.getRequestDispatcher("/BuginessProductListServlet");
		} else {
			int productID = Integer.parseInt(productIDString);
			ProductGetLogic bo = new ProductGetLogic();
			Product product = bo.getOne(productID);
			HttpSession session = request.getSession();
			session.setAttribute("product", product);
			dispatcher = request.getRequestDispatcher("WEB-INF/jsp/productChangeForm.jsp");
		}
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//リクエストパラメータの取得
		String productName = request.getParameter("productName");
		String productPriceString =  request.getParameter("productPrice");
		String productCountString = request.getParameter("productCount");
		String productDescription = request.getParameter("productDescription");

		System.out.println(productPriceString);
		RequestDispatcher dispatcher = null;

		//nullチェック
		if(productName == null||productName.length() == 0) {
			dispatcher = request.getRequestDispatcher("WEB-INF/jsp/productChangeForm.jsp");
		}
		if(productPriceString == null||productPriceString.length() == 0) {
			dispatcher = request.getRequestDispatcher("WEB-INF/jsp/productChangeForm.jsp");
		}
		if(productCountString == null||productCountString.length() == 0) {
			dispatcher = request.getRequestDispatcher("WEB-INF/jsp/productChangeForm.jsp");
		}
		if(productDescription == null||productDescription.length() == 0) {
			dispatcher = request.getRequestDispatcher("WEB-INF/jsp/productChangeForm.jsp");
		}
		if (dispatcher == null) {

			int productPrice = Integer.parseInt(productPriceString);
			int productCount = Integer.parseInt(productCountString);

			//画像ファイルのアップロード処理
			Part part = request.getPart("productImage");
	        String productImageName = this.getFileName(part);
	        part.write("/Users/koyamatakumi/git/sukkiriShop/WebContent/uploadImage/" + productImageName);

			//正規表現でチェック

			//製品情報をbusinessIDと付随して確認画面で表示する
			HttpSession session = request.getSession();
			String businessID = (String) session.getAttribute("businessID");
			Product product = (Product) session.getAttribute("product");

			//変更点のみ書き換えて、再度スコープに保存する
			product.setBusinessID(businessID);
			if(!product.getProductName().equals(productName)) {
				product.setProductName(productName);
			};
			if(product.getProductPrice()!=productPrice) {
				product.setProductPrice(productPrice);
			};
			if(product.getProductCount()!=productCount) {
				product.setProductCount(productCount);
			};
			if(!product.getProductDescription().equals(productDescription)) {
				product.setProductDescription(productDescription);
			};
			if(!product.getProductImage().equals(productImageName)) {
				product.setProductImage(productImageName);
			};

			session.setAttribute("product", product);

			//確認画面にフォワード
			dispatcher = request.getRequestDispatcher("WEB-INF/jsp/productChangeCheck.jsp");
		}
		dispatcher.forward(request, response);
	}
    private String getFileName(Part part) {
        String productImageName = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
            	productImageName = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
            	productImageName = productImageName.substring(productImageName.lastIndexOf("\\") + 1);
                break;
            }
        }
        return productImageName;
    }

}
