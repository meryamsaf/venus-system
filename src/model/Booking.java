package model;


import java.util.Date;

public class Booking {
	private int bookingID;
	private Date bDate;
	private String bTime;
	private double bTotalPrice;
	private int rating;
	private int custID;
	private int serviceID;
	private String staffID;
	private String sName;
	private String svName;
	private String cName;
	private double svPrice;
	
	
	
	
	public Booking() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	public Booking(int bookingID, Date bDate, String bTime, double bTotalPrice, int rating, int custID, int serviceID,
			String staffID, String sName, String svName, String cName) {
		
		this.bookingID = bookingID;
		this.bDate = bDate;
		this.bTime = bTime;
		this.bTotalPrice = bTotalPrice;
		this.rating = rating;
		this.custID = custID;
		this.serviceID = serviceID;
		this.staffID = staffID;
		this.sName = sName;
		this.svName = svName;
		this.cName = cName;
		
	}


	public Booking(int bookingID, Date bDate, String bTime, double bTotalPrice, String svName, String cName) {
		
		this.bookingID = bookingID;
		this.bDate = bDate;
		this.bTime = bTime;
		this.bTotalPrice = bTotalPrice;
		this.svName = svName;
		this.cName = cName;
	}


	public Booking(int bookingID, Date bDate, String bTime, double bTotalPrice, int rating, String sName, String svName,
			String cName) {
	
		this.bookingID = bookingID;
		this.bDate = bDate;
		this.bTime = bTime;
		this.bTotalPrice = bTotalPrice;
		this.rating = rating;
		this.sName = sName;
		this.svName = svName;
		this.cName = cName;
	}

	public double getSvPrice() {
		return svPrice;
	}


	public void setSvPrice(double svPrice) {
		this.svPrice = svPrice;
	}


	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getSvName() {
		return svName;
	}

	public void setSvName(String svName) {
		this.svName = svName;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getBookingID() {
		return bookingID;
	}
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public String getbTime() {
		return bTime;
	}
	public void setbTime(String newTime) {
		this.bTime = newTime;
	}
	public double getbTotalPrice() {
		return bTotalPrice;
	}
	public void setbTotalPrice(double bTotalPrice) {
		this.bTotalPrice = bTotalPrice;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public int getServiceID() {
		return serviceID;
	}
	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}
	public String getStaffID() {
		return staffID;
	}
	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}
	
	
}
