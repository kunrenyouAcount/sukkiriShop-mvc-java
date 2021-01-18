package model;

import java.io.Serializable;

public class BusinessLogin implements Serializable {
	private String businessID;
	private String businessPass;
	public BusinessLogin() {}
	public BusinessLogin(String businessID, String businessPass) {
		this.businessID = businessID;
		this.businessPass = businessPass;
	}

	public String getBusinessID() {
		return businessID;
	}
	public String getBusinessPass() {
		return businessPass;
	}
}
