package model;

import java.util.List;

import dao.ProductDAO;

public class PurchaseLogic {
	public boolean subtractionProduct(List<Product> cart) {
		ProductDAO dao = new ProductDAO();
		boolean result = dao.updateMulti(cart);
		return result;
	}
}