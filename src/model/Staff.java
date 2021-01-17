package model;

public class Staff {

	private String staffID,sName,sNum,sPassword,adminID;
	public boolean valid;



	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsNum() {
		return sNum;
	}

	public void setsNum(String sNum) {
		this.sNum = sNum;
	}

	public String getsPassword() {
		return sPassword;
	}

	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	
	public void setValid(boolean valid) {
		this.valid = valid;
		
	}

	public boolean isValid() {
		// TODO Auto-generated method stub
		return valid;
	}

	
	
}
