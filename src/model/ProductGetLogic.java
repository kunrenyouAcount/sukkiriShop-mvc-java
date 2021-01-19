package model;
import java.util.List;

import dao.ProductDAO;

public class ProductGetLogic {
	public List<Product> getAll() {
		ProductDAO dao = new ProductDAO();
		List<Product> productList = dao.getAll();
		return productList;
	}
	public Product getOne(int ProductID) {
		ProductDAO dao = new ProductDAO();
		Product product = dao.getOne(ProductID);
		return product;
	}
}
