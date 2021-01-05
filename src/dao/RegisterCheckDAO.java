package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;

public class RegisterCheckDAO {
	final String servername = "localhost";
	final String databasename = "sukkirishop";

	//データベース接続情報
	final String JDBC_URL = "jdbc:mysql://" + servername + "/" + databasename + "?serverTimeZone=JST";
	final String DB_USER = "root";
	final String DB_PASS = "";

	public Account checkByAccount(Account account) {
		Account checkedAccount = null;

		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SELECT文を準備
			String sql = "select user_id, pass, mail, name, age from account where user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, account.getUserId());

			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//一致したユーザーが存在した場合そのユーザーを表すAccountインスタンスを生成
			if (rs.next()) {
				//結果表からデータを取得
				String userId = rs.getString("user_id");
				String pass = rs.getString("pass");
				String mail = rs.getString("mail");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				checkedAccount = new Account(userId, pass, mail, name, age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//見つかったユーザーまたはnullを返す
		return checkedAccount;
	}
}