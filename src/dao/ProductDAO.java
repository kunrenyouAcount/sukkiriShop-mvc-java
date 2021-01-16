package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;

//productテーブルを操作するためのDAOクラス
public class ProductDAO {
	final String servername = "localhost";
	final String databasename = "sukkirishop";

	//データベース接続情報
	final String JDBC_URL = "jdbc:mysql://" + servername + "/" + databasename + "?serverTimeZone=JST";
	final String DB_USER = "root";
	final String DB_PASS = "";

	public List<Product> getAll() {
		List<Product> productList = new ArrayList<>();
		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SELECT文を準備
			String sql = "select productID, productName,  productPrice, productCount, productDescription from product";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//一致したユーザーが存在した場合そのユーザーを表すAccountインスタンスを生成
			while (rs.next()) {
				//結果表からデータを取得
				int productID = rs.getInt("productID");
				String productName = rs.getString("productName");
				int productPrice = rs.getInt("productPrice");
				int productCount = rs.getInt("productCount");
				String productDescription = rs.getString("productDescription");
				Product product = new Product(productID, productName, productPrice, productCount, productDescription);
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//見つかったユーザーまたはnullを返す
		return productList;
	}

	public Product getOne(int selectedProductID) {
		Product product = null;
		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SELECT文を準備
			String sql = "select productID, productName,  productPrice, productCount, productDescription from product where productID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, selectedProductID);

			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//一致したユーザーが存在した場合そのユーザーを表すAccountインスタンスを生成
			if (rs.next()) {
				//結果表からデータを取得
				int productID = rs.getInt("productID");
				String productName = rs.getString("productName");
				int productPrice = rs.getInt("productPrice");
				int productCount = rs.getInt("productCount");
				String productDescription = rs.getString("productDescription");
				product = new Product(productID, productName, productPrice, productCount, productDescription);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//見つかったユーザーまたはnullを返す
		return product;
	}

	public boolean subtractionProduct(List<Product> cart) {
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			int result = 0;
			for(Product product: cart) {
				//SELECT文を準備
				String sql = "update product set productCount = (select productCount from product where productID = ?) - ? where productID = ?";
				//セレクト文をプリペアに格納
				PreparedStatement pStmt = conn.prepareStatement(sql);
				//SQL文を完成
				pStmt.setInt(1, product.getProductID());
				pStmt.setInt(2, product.getProductCount());
				pStmt.setInt(3, product.getProductID());
				//SELECT文を実行し、結果表を取得
				result += pStmt.executeUpdate();
			}
			if(result != cart.size()) {
			//カートに入っている種類分変更されていなければfalseを返す
				return false;
			}
		} catch (SQLException e) {
		//実行中にエラーが起きた場合もfalseを返す
			e.printStackTrace();
			return false;
		}
		//上記以外は成功と見なし、trueを返す
		return true;
	}
}