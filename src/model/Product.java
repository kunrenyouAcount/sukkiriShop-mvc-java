package model;

import java.io.Serializable;

public class Product implements Serializable {
	private int productID;
	private String productName;
	private int productPrice;
	private int productCount;
	private String productDescription;
	private String productImage;
	private String businessID;

	public Product() {}
	//ユーザー用
	public Product(int productID, String productName, int productPrice, int productCount, String productDescription, String productImage) {
		this.productID = productID;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCount = productCount;
		this.productDescription = productDescription;
		this.productImage = productImage;
	}
	//業者用
	public Product(int productID, String productName, int productPrice, int productCount, String productDescription,String productImage, String businessID) {
		this.productID = productID;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCount = productCount;
		this.productDescription = productDescription;
		this.productImage = productImage;
		this.businessID = businessID;
	}
	public Product(String productName, int productPrice, int productCount, String productDescription, String productImage, String businessID) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCount = productCount;
		this.productDescription = productDescription;
		this.productImage = productImage;
		this.businessID = businessID;
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
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getBusinessID() {
		return businessID;
	}
	public void setBusinessID(String businessID) {
		this.businessID = businessID;
	}
}