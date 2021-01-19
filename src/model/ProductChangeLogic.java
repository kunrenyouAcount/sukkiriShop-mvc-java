package model;

import dao.ProductDAO;

public class ProductChangeLogic {

	public boolean changeProduct(Product product) {
		ProductDAO dao = new ProductDAO();
		boolean result = dao.updateProduct(product);
		return result;
	}

}
