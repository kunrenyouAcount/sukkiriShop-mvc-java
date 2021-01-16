package model;

import dao.UserDAO;

public class LoginLogic {
	public boolean execute(Login login) {
		//データベースにアクセスするためのDAOクラスをインスタンス化し、
		//「アカウントがnullじゃない」→「入力したアカウントが有」→「ログイン可能」(true)、
		//「アカウントがnull」→「入力したアカウントが無」→「ログイン不可」(false)
		//を返す
		UserDAO dao = new UserDAO();
		User user = dao.findByLogin(login);
		return user != null;
	}
}
