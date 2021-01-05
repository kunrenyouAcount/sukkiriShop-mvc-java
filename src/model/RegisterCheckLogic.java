package model;

import dao.RegisterCheckDAO;

public class RegisterCheckLogic {
	public boolean execute(Account account) {
		RegisterCheckDAO dao = new RegisterCheckDAO();
		Account checkedAccount = dao.checkByAccount(account);
		return checkedAccount != null;
	}
}
