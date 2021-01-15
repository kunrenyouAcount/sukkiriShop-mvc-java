package model;
import java.util.List;

import dao.ProductDAO;

public class ProductListLogic {
	public List<Product> getAll() {
		ProductDAO dao = new ProductDAO();
		List<Product> productList = dao.getAll();
		return productList;
	}
	public Product getOne(int product_id) {
		ProductDAO dao = new ProductDAO();
		Product product = dao.getOne(product_id);
		return product;
	}
}
