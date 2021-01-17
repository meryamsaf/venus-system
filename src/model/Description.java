package model;

import java.util.Date;

public class Description {
	private int descid;
	private String descname;
	private Date descdate;
	private int forumID;
	private String staffID;
	private int custID;
	
	public Description(int descid, String descname, Date descdate, int forumID, String staffID, int custID) {
		super();
		this.descid = descid;
		this.descname = descname;
		this.descdate = descdate;
		this.forumID = forumID;
		this.staffID = staffID;
		this.custID = custID;
	}

	public Description() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDescid() {
		return descid;
	}

	public void setDescid(int descid) {
		this.descid = descid;
	}

	public String getDescname() {
		return descname;
	}

	public void setDescname(String descname) {
		this.descname = descname;
	}

	public Date getDescdate() {
		return descdate;
	}

	public void setDescdate(Date descdate) {
		this.descdate = descdate;
	}

	public int getForumID() {
		return forumID;
	}

	public void setForumID(int forumID) {
		this.forumID = forumID;
	}

	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}
	
	
	
	
}
