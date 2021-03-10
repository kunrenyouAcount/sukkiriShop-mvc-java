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
	final String DB_USER = "user";
	final String DB_PASS = "password";

	public List<Product> selectAll() {
		List<Product> productList = new ArrayList<>();
		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SELECT文を準備
			String sql = "select productID, productName,  productPrice, productCount, productDescription, productImage from product";
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
				String productImage = rs.getString("productImage");
				Product product = new Product(productID, productName, productPrice, productCount, productDescription, productImage);
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//見つかったユーザーまたはnullを返す
		return productList;
	}

	public Product selectOne(int selectedProductID) {
		Product product = null;
		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SELECT文を準備
			String sql = "select productID, productName,  productPrice, productCount, productDescription, productImage from product where productID = ?";
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
				String productImage = rs.getString("productImage");
				product = new Product(productID, productName, productPrice, productCount, productDescription, productImage);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//見つかったユーザーまたはnullを返す
		return product;
	}

	public boolean updateMulti(List<Product> cart) {
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

	public List<Product> selectOneByBusinessID(String businessID) {
		List<Product> productList = new ArrayList<>();
		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SELECT文を準備
			String sql = "select productID, productName,  productPrice, productCount, productDescription, productImage, businessID from product WHERE businessID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//SQL文を完成
			pStmt.setString(1, businessID);

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
				String productImage = rs.getString("productImage");
				String getBusinessID = rs.getString("businessID");
				Product product = new Product(productID, productName, productPrice, productCount, productDescription,productImage, getBusinessID);
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//見つかったユーザーまたはnullを返す
		return productList;
	}

	public boolean insertProduct(Product product) {
		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SELECT文を準備
			String sql = "INSERT INTO product (productName,  productPrice, productCount, productDescription, productImage, businessID) VALUES (?, ?, ?, ?, ?, ?)";
			//セレクト文をプリペアに格納
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//VALUESの中身を引数の値から設定
			pStmt.setString(1, product.getProductName());
			pStmt.setInt(2, product.getProductPrice());
			pStmt.setInt(3, product.getProductCount());
			pStmt.setString(4, product.getProductDescription());
			pStmt.setString(5, product.getProductImage());
			pStmt.setString(6, product.getBusinessID());

			//SELECT文を実行し、結果表を取得
			int result = pStmt.executeUpdate();
			if(result != 1) {
			//1件のデータを登録しているため、それ以外だった場合には登録失敗のfalseを返す
				return false;
			}
		} catch (SQLException e) {
		//エラーが出た場合も登録失敗のfalseを返す
			e.printStackTrace();
			return false;
		}
	//登録件数が1件でエラーも出ていないため登録完了のtrueを返す
		return true;
	}

	public boolean updateProduct(Product product) {
		//データベースへ接続
				try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
					//SELECT文を準備
					String sql = "UPDATE product SET productName = ?,  productPrice =?, productCount = ?, productDescription = ?, productImage = ? WHERE productID = ? ";
					//セレクト文をプリペアに格納s
					PreparedStatement pStmt = conn.prepareStatement(sql);
					//VALUESの中身を引数の値から設定
					pStmt.setString(1, product.getProductName());
					pStmt.setInt(2, product.getProductPrice());
					pStmt.setInt(3, product.getProductCount());
					pStmt.setString(4, product.getProductDescription());
					pStmt.setInt(5, product.getProductID());
					pStmt.setString(6, product.getProductImage());
					//SELECT文を実行し、結果表を取得
					int result = pStmt.executeUpdate();
					if(result != 1) {
					//1件のデータを登録しているため、それ以外だった場合には登録失敗のfalseを返す
						return false;
					}
				} catch (SQLException e) {
				//エラーが出た場合も登録失敗のfalseを返す
					e.printStackTrace();
					return false;
				}
			//登録件数が1件でエラーも出ていないため登録完了のtrueを返す
			return true;
	}
}