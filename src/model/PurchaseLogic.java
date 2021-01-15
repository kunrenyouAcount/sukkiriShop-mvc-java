package model;

import java.util.List;

import dao.ProductDAO;

public class PurchaseLogic {
	public boolean execute(List<Product> cart) {
		ProductDAO dao = new ProductDAO();
		boolean result = dao.subtractionProduct(cart);
		return result;
	}
}
