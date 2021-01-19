package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Business;
import model.BusinessLogin;

public class BusinessDAO {
	final String servername = "localhost";
	final String databasename = "sukkirishop";

	//データベース接続情報
	final String JDBC_URL = "jdbc:mysql://" + servername + "/" + databasename + "?serverTimeZone=JST";
	final String DB_USER = "root";
	final String DB_PASS = "";

	//businessIDが登録済みかどうか確認
	public Business selectBybusinessID(Business business) {
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

	public boolean insertBusiness(Business business) {
		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SELECT文を準備
			String sql = "INSERT INTO business ( businessID, businessPass, businessMail, businessName ) VALUES ( ?, ?, ?, ?)";
			//セレクト文をプリペアに格納
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//VALUESの中身を引数の値から設定
			pStmt.setString(1, business.getBusinessID());
			pStmt.setString(2, business.getBusinessPass());
			pStmt.setString(3, business.getBusinessMail());
			pStmt.setString(4, business.getBusinessName());

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

	//ログイン情報をもとにアカウントを検索(ログイン認証)
	public Business selectByBusinessLogin(BusinessLogin businessLogin) {
		Business business = null;

		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SELECT文を準備
			String sql = "select businessID, businessPass, businessMail, businessName from business where businessID = ? and businessPass = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, businessLogin.getBusinessID());
			pStmt.setString(2, businessLogin.getBusinessPass());

			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//一致したユーザーが存在した場合そのユーザーを表すAccountインスタンスを生成
			if (rs.next()) {
				//結果表からデータを取得
				String businessID = rs.getString("businessID");
				String businessPass = rs.getString("businessPass");
				String businessMail = rs.getString("businessMail");
				String businessName = rs.getString("businessName");
				business = new Business(businessID, businessPass, businessMail, businessName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//見つかったユーザーまたはnullを返す
		return business;
	}


}
