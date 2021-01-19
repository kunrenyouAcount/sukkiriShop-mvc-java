package servlet;

import java.io.IOException;
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

@WebServlet("/BusinessProductListServlet")
public class BusinessProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String businessID = (String)session.getAttribute("businessID");
		RequestDispatcher dispatcher;
		if(businessID == null) {
			dispatcher = request.getRequestDispatcher("WEB-INF/jsp/businessWelcome.jsp");
		} else {
			ProductGetLogic bo = new ProductGetLogic();
			List<Product> businessProductList = bo.getAllByBusinessID(businessID);
			request.setAttribute("businessProductList", businessProductList);
			dispatcher = request.getRequestDispatcher("WEB-INF/jsp/businessProductList.jsp");
		}
		dispatcher.forward(request, response);
	}
}
