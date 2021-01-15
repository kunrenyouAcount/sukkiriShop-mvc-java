package model;

import dao.AccountDAO;

public class RegisterCheckLogic {
	public boolean execute(Account account) {
		//データベースにアクセスするためのDAOクラスをインスタンス化し、登録済み(true)、未登録(false)を返す
		AccountDAO dao = new AccountDAO();
		Account checkedAccount = dao.checkByUserId(account);
		return checkedAccount != null;
	}
}
