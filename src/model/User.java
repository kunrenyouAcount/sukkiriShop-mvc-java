package model;

public class User {
	private String userID;
	private String userPass;
	private String userMail;
	private String userName;
	private String userAddress;

	public User() {}
	public User(String userID, String userPass, String userMail, String userName, String userAddress) {
		this.userID = userID;
		this.userPass = userPass;
		this.userMail = userMail;
		this.userName = userName;
		this.userAddress = userAddress;
	}
	public String getUserID() {
		return userID;
	}
	public String getUserPass() {
		return userPass;
	}
	public String getUserMail() {
		return userMail;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserAddress() {
		return userAddress;
	}
}