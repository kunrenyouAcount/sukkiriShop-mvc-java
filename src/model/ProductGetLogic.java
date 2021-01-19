package model;
import java.util.List;

import dao.ProductDAO;

public class ProductGetLogic {
	public List<Product> getAll() {
		ProductDAO dao = new ProductDAO();
		List<Product> productList = dao.selectAll();
		return productList;
	}
	public Product getOne(int productID) {
		ProductDAO dao = new ProductDAO();
		Product product = dao.selectOne(productID);
		return product;
	}

	public List<Product> getAllByBusinessID(String businessID) {
		ProductDAO dao = new ProductDAO();
		List<Product> productList = dao.selectOneByBusinessID(businessID);
		return productList;
	}
}
