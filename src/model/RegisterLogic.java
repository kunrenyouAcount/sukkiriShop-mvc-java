package model;

import dao.RegisterDAO;

public class RegisterLogic {
	public boolean execute(Account account) {
		RegisterDAO dao = new RegisterDAO();
		boolean result = dao.registerAccount(account);
		return result;
	}
}
