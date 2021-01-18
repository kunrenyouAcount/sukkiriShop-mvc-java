package model;

import dao.BusinessDAO;
import dao.UserDAO;

public class RegisterLogic {
	public boolean execute(User user) {
		//データベースにアクセスするためのDAOクラスをインスタンス化し、処理結果をboolean型で返す
		UserDAO dao = new UserDAO();
		boolean result = dao.registerUser(user);
		return result;
	}
	public boolean execute(Business business) {
		//データベースにアクセスするためのDAOクラスをインスタンス化し、処理結果をboolean型で返す
		BusinessDAO dao = new BusinessDAO();
		boolean result = dao.registerBusiness(business);
		return result;
	}
}
