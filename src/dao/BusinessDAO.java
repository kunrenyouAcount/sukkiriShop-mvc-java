package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Business;

public class BusinessDAO {
	final String servername = "localhost";
	final String databasename = "sukkirishop";

	//データベース接続情報
	final String JDBC_URL = "jdbc:mysql://" + servername + "/" + databasename + "?serverTimeZone=JST";
	final String DB_USER = "root";
	final String DB_PASS = "";

	public Business checkBybusinessID(Business business) {
		Business checkedBusiness = null;

		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SELECT文を準備
			String sql = "select businessID, businessPass, businessMail, businessName from business where businessID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, business.getBusinessID());

			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//一致したユーザーが存在した場合そのユーザーを表すAccountインスタンスを生成
			if (rs.next()) {
				//結果表からデータを取得
				String businessID = rs.getString("businessID");
				String businessPass = rs.getString("businessPass");
				String businessMail = rs.getString("businessMail");
				String businessName = rs.getString("businessName");
				checkedBusiness = new Business(businessID, businessPass, businessMail, businessName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//見つかったユーザーまたはnullを返す
		return checkedBusiness;
	}


}
