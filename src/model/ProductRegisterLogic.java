package model;

import dao.ProductDAO;

public class ProductRegisterLogic {

	public boolean productRegister(Product product) {
		ProductDAO dao = new ProductDAO();
		boolean result = dao.insertProduct(product);
		return result;
	}
}
