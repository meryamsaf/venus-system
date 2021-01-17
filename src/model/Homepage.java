package model;

public class Homepage {
	
	private int vID;
	private String vName,vLocation,vPhone,vDetails,staffID;
	
    public int getvID() {
		return vID;
	}
	public void setvID(int vID) {
		this.vID = vID;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	public String getvLocation() {
		return vLocation;
	}
	public void setvLocation(String vLocation) {
		this.vLocation = vLocation;
	}
	public String getvPhone() {
		return vPhone;
	}
	public void setvPhone(String vPhone) {
		this.vPhone = vPhone;
	}
	public String getvDetails() {
		return vDetails;
	}
	public void setvDetails(String vDetails) {
		this.vDetails = vDetails;
	}
	public String getStaffID() {
		return staffID;
	}
	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}
    
}