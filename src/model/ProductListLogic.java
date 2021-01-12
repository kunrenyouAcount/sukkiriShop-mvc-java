package model;
import java.util.List;

import dao.ProductListDAO;

public class ProductListLogic {
	public List<Product> getAll() {
		ProductListDAO dao = new ProductListDAO();
		List<Product> productList = dao.getAll();
		return productList;
	}
	public Product getOne(int product_id) {
		ProductListDAO dao = new ProductListDAO();
		Product product = dao.getOne(product_id);
		return product;
	}
}
