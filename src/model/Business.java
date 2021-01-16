package model;

import java.io.Serializable;

public class Business implements Serializable {
	private String businessID;
	private String businessPass;
	private String businessMail;
	private String businessName;

	public Business() {}
	public Business(String businessID, String businessPass, String businessMail, String businessName) {
		this.businessID = businessID;
		this.businessPass = businessPass;
		this.businessMail = businessMail;
		this.businessName = businessName;
	}

	public String getBusinessID() {
		return businessID;
	}
	public String getBusinessPass() {
		return businessPass;
	}
	public String getBusinessMail() {
		return businessMail;
	}
	public String getBusinessName() {
		return businessName;
	}
}
