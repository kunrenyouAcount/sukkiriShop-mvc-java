package model;

import dao.RegisterCheckDAO;

public class RegisterCheckLogic {
	public boolean execute(Account account) {
		//データベースにアクセスするためのDAOクラスをインスタンス化し、登録済み(true)、未登録(false)を返す
		RegisterCheckDAO dao = new RegisterCheckDAO();
		Account checkedAccount = dao.checkByAccount(account);
		return checkedAccount != null;
	}
}
