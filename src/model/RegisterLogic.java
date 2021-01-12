package model;

import dao.RegisterDAO;

public class RegisterLogic {
	public boolean execute(Account account) {
		//データベースにアクセスするためのDAOクラスをインスタンス化し、処理結果をboolean型で返す
		RegisterDAO dao = new RegisterDAO();
		boolean result = dao.registerAccount(account);
		return result;
	}
}
