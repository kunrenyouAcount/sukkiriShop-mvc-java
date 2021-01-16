package model;

import java.io.Serializable;

public class Product implements Serializable {
	private int productID;
	private String productName;
	private int productPrice;
	private int productCount;
	private String productDescription;

	public Product() {}
	public Product(int productID, String productName, int productPrice, int productCount, String productDescription) {
		this.productID = productID;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCount = productCount;
		this.productDescription = productDescription;
	}

	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
}