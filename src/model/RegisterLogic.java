package model;

import dao.UserDAO;

public class RegisterLogic {
	public boolean execute(User user) {
		//データベースにアクセスするためのDAOクラスをインスタンス化し、処理結果をboolean型で返す
		UserDAO dao = new UserDAO();
		boolean result = dao.registerUser(user);
		return result;
	}
}
