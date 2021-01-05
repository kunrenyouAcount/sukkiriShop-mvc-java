package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Account;

public class RegisterDAO {
	final String servername = "localhost";
	final String databasename = "sukkirishop";

	//データベース接続情報
	final String JDBC_URL = "jdbc:mysql://" + servername + "/" + databasename + "?serverTimeZone=JST";
	final String DB_USER = "root";
	final String DB_PASS = "";

	public boolean registerAccount(Account account) {
		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SELECT文を準備
			String sql = "INSERT INTO account ( user_id, pass, mail, name, age ) VALUES ( ?, ?, ?, ? , ? )";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, account.getUserId());
			pStmt.setString(2, account.getPass());
			pStmt.setString(3, account.getMail());
			pStmt.setString(4, account.getName());
			pStmt.setInt(5, account.getAge());

			//SELECT文を実行し、結果表を取得
			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	return true;
	}
}