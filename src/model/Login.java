package model;

public class Login {
	private String userID;
	private String userPass;

	public Login() {}
	public Login(String userID, String userPass) {
		this.userID = userID;
		this.userPass = userPass;
	}

	public String getUserID() {
		return userID;
	}
	public String getUserPass() {
		return userPass;
	}
}
