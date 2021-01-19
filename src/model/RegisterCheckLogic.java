package model;

import dao.BusinessDAO;
import dao.UserDAO;

public class RegisterCheckLogic {
	public boolean checkByUser(User user) {
		//データベースにアクセスするためのDAOクラスをインスタンス化し、登録済み(true)、未登録(false)を返す
		UserDAO dao = new UserDAO();
		User checkedUser = dao.selectByUserID(user);
		return checkedUser != null;
	}
	public boolean checkByBusiness(Business business) {
		//データベースにアクセスするためのDAOクラスをインスタンス化し、登録済み(true)、未登録(false)を返す
		BusinessDAO dao = new BusinessDAO();
		Business checkedBusiness = dao.selectBybusinessID(business);
		return checkedBusiness != null;
	}
}
