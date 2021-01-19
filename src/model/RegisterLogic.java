package model;

import dao.BusinessDAO;
import dao.UserDAO;

public class RegisterLogic {
	public boolean registerUser(User user) {
		//データベースにアクセスするためのDAOクラスをインスタンス化し、処理結果をboolean型で返す
		UserDAO dao = new UserDAO();
		boolean result = dao.insertUser(user);
		return result;
	}
	public boolean registerBusiness(Business business) {
		//データベースにアクセスするためのDAOクラスをインスタンス化し、処理結果をboolean型で返す
		BusinessDAO dao = new BusinessDAO();
		boolean result = dao.insertBusiness(business);
		return result;
	}
}
