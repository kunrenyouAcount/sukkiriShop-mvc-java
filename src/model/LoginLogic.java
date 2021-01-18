package model;

import dao.BusinessDAO;
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
	public boolean execute(BusinessLogin businessLogin) {
		//データベースにアクセスするためのDAOクラスをインスタンス化し、
		//「アカウントがnullじゃない」→「入力したアカウントが有」→「ログイン可能」(true)、
		//「アカウントがnull」→「入力したアカウントが無」→「ログイン不可」(false)
		//を返す
		BusinessDAO dao = new BusinessDAO();
		Business business = dao.findByBusinessLogin(businessLogin);
		return business !=null;
	}
}
