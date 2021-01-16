package model;
import java.util.List;

import dao.ProductDAO;

public class ProductListLogic {
	public List<Product> getAll() {
		ProductDAO dao = new ProductDAO();
		List<Product> productList = dao.getAll();
		return productList;
	}
	public Product getOne(int selectedProductID) {
		ProductDAO dao = new ProductDAO();
		Product product = dao.getOne(selectedProductID);
		return product;
	}
}
