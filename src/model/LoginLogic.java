package model;

import dao.LoginDAO;

public class LoginLogic {
	public boolean execute(Login login) {
		LoginDAO dao = new LoginDAO();
		Account account = dao.findByLogin(login);
		return account != null;
	}
}
