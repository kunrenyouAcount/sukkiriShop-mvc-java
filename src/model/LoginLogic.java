package model;

import dao.AccountDAO;

public class LoginLogic {
	public boolean execute(Login login) {
		//データベースにアクセスするためのDAOクラスをインスタンス化し、
		//「アカウントがnullじゃない」→「入力したアカウントが有」→「ログイン可能」(true)、
		//「アカウントがnull」→「入力したアカウントが無」→「ログイン不可」(false)
		//を返す
		AccountDAO dao = new AccountDAO();
		Account account = dao.findByLogin(login);
		return account != null;
	}
}
