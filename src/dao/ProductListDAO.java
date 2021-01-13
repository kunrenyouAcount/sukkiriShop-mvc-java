package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductListDAO {
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
			String sql = "select product_id, product_name,  product_price, product_count, product_description from product";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//一致したユーザーが存在した場合そのユーザーを表すAccountインスタンスを生成
			while (rs.next()) {
				//結果表からデータを取得
				int id = rs.getInt("product_id");
				String name = rs.getString("product_name");
				int price = rs.getInt("product_price");
				int count = rs.getInt("product_count");
				String description = rs.getString("product_description");
				Product product = new Product(id, name, price, count, description);
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//見つかったユーザーまたはnullを返す
		return productList;
	}

	public Product getOne(int product_id) {
		Product product = null;
		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SELECT文を準備
			String sql = "select product_id, product_name,  product_price, product_count, product_description from product where product_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, product_id);

			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//一致したユーザーが存在した場合そのユーザーを表すAccountインスタンスを生成
			if (rs.next()) {
				//結果表からデータを取得
				int id = rs.getInt("product_id");
				String name = rs.getString("product_name");
				int price = rs.getInt("product_price");
				int count = rs.getInt("product_count");
				String description = rs.getString("product_description");
				product = new Product(id, name, price, count, description);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//見つかったユーザーまたはnullを返す
		return product;
	}
}