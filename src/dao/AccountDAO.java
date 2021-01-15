package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

//accountテーブルを操作するためのDAOクラス
public class AccountDAO {
	final String servername = "localhost";
	final String databasename = "sukkirishop";

	//データベース接続情報
	final String JDBC_URL = "jdbc:mysql://" + servername + "/" + databasename + "?serverTimeZone=JST";
	final String DB_USER = "root";
	final String DB_PASS = "";

	//ログイン情報でアカウントが見つかるか検索
	public Account findByLogin(Login login) {
		Account account = null;

		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SELECT文を準備
			String sql = "select user_id, pass, mail, name, age from account where user_id = ? and pass = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getUserId());
			pStmt.setString(2, login.getPass());

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
				account = new Account(userId, pass, mail, name, age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//見つかったユーザーまたはnullを返す
		return account;
	}

	//userIdが使用済みかどうか検索
	public Account checkByUserId(Account account) {
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

	//アカウントを新規登録
	public boolean registerAccount(Account account) {
			//データベースへ接続
			try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
				//SELECT文を準備
				String sql = "INSERT INTO account ( user_id, pass, mail, name, age ) VALUES ( ?, ?, ?, ? , ? )";
				//セレクト文をプリペアに格納
				PreparedStatement pStmt = conn.prepareStatement(sql);
				//VALUESの中身を引数の値から設定
				pStmt.setString(1, account.getUserId());
				pStmt.setString(2, account.getPass());
				pStmt.setString(3, account.getMail());
				pStmt.setString(4, account.getName());
				pStmt.setInt(5, account.getAge());

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