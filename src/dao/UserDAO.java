package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Login;
import model.User;

//accountテーブルを操作するためのDAOクラス
public class UserDAO {
	final String servername = "localhost";
	final String databasename = "sukkirishop";

	//データベース接続情報
	final String JDBC_URL = "jdbc:mysql://" + servername + "/" + databasename + "?serverTimeZone=JST";
	final String DB_USER = "user";
	final String DB_PASS = "password";

	//ログイン情報でアカウントが見つかるか検索
	public User selectByLogin(Login login) {
		User user = null;

		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SELECT文を準備
			String sql = "select userID, userPass, userMail, userName, userAddress from user where userID = ? and userPass = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getUserID());
			pStmt.setString(2, login.getUserPass());

			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//一致したユーザーが存在した場合そのユーザーを表すAccountインスタンスを生成
			if (rs.next()) {
				//結果表からデータを取得
				String userID = rs.getString("userID");
				String userPass = rs.getString("userPass");
				String userMail = rs.getString("userMail");
				String userName = rs.getString("userName");
				String userAddress  = rs.getString("userAddress");
				user = new User(userID, userPass, userMail, userName, userAddress);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//見つかったユーザーまたはnullを返す
		return user;
	}

	//userIdが使用済みかどうか検索
	public User selectByUserID(User user) {
		User checkedUser = null;

		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SELECT文を準備
			String sql = "select userID, userPass, userMail, userName, userAddress from user where userID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getUserID());

			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//一致したユーザーが存在した場合そのユーザーを表すAccountインスタンスを生成
			if (rs.next()) {
				//結果表からデータを取得
				String userID = rs.getString("userID");
				String userPass = rs.getString("userPass");
				String userMail = rs.getString("userMail");
				String userName = rs.getString("userName");
				String userAddress = rs.getString("userAddress");
				checkedUser = new User(userID, userPass, userMail, userName, userAddress);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//見つかったユーザーまたはnullを返す
		return checkedUser;
	}

	//アカウントを新規登録
	public boolean insertUser(User user) {
			//データベースへ接続
			try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
				//SELECT文を準備
				String sql = "INSERT INTO user ( userID, userPass, userMail, userName, userAddress ) VALUES ( ?, ?, ?, ? , ? )";
				//セレクト文をプリペアに格納
				PreparedStatement pStmt = conn.prepareStatement(sql);
				//VALUESの中身を引数の値から設定
				pStmt.setString(1, user.getUserID());
				pStmt.setString(2, user.getUserPass());
				pStmt.setString(3, user.getUserMail());
				pStmt.setString(4, user.getUserName());
				pStmt.setString(5, user.getUserAddress());

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