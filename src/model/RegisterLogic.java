package model;

import dao.AccountDAO;

public class RegisterLogic {
	public boolean execute(Account account) {
		//データベースにアクセスするためのDAOクラスをインスタンス化し、処理結果をboolean型で返す
		AccountDAO dao = new AccountDAO();
		boolean result = dao.registerAccount(account);
		return result;
	}
}
