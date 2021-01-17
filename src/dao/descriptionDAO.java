package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import connection.ConnectionManager;
import model.Description;
import model.Forum;

public class descriptionDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static int descid, forumID, custID;
	static String staffID, descname; 
	static Date descdate; 

	
	//add data
    public  void addDescription(Description bean)
    {
        //get values
    	descname = bean.getDescname();
		descdate = bean.getDescdate();
		forumID = bean.getForumID();
		custID = bean.getCustID();
		staffID = bean.getStaffID();
		
		System.out.println("Your date name is " + descname);
		System.out.println("Your time is " + descdate);
		System.out.println("total: " + forumID);
		System.out.println("Your custID is " + custID);
		System.out.println("Your staff is " + staffID);
		
        try 
        {
            //step 2: create connection
             con = ConnectionManager.getConnection();
             SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
             String bdate = dateFormat.format(descdate);
             
            
            //step3 : create statement - using preparedStatement
            ps=con.prepareStatement("insert into description(descname,descdate,forumID,custID,staffID)values(?,?,?,?,?)");
            
            ps.setString(1, descname);
            ps.setDate(2,java.sql.Date.valueOf(bdate));
            ps.setInt(3, forumID);
            ps.setInt(4,custID);
            ps.setString(5, staffID);
            System.out.print(ps);
            //step 4: execute statement
            ps.executeUpdate();
            //step 5: close connection
            con.close();
        }
        catch (Exception ex) 
        {
            System.out.println("failed: An Exception has occurred! " + ex);
        }
    }
    

    
    //list data
    public static List<Description> getAllDescription() throws ClassNotFoundException, SQLException
    {
        List<Description> sups = new ArrayList<>();
        
        try {
            con = ConnectionManager.getConnection();
             ps=con.prepareStatement("select * from description where forumID=?");

             ps.setInt(1, forumID);
             ResultSet rs = ps.executeQuery();
        
       
        while (rs.next()) 
        {
        	 
 	        descid=rs.getInt("descid");
 	        descname=rs.getString("descname");
 	        descdate=rs.getDate("descdate");
 	        forumID=rs.getInt("forumID");
 	        custID=rs.getInt("custID");
 	        staffID=rs.getString("staffID");
        
       
	        Description desc = new Description(descid, descname, descdate, forumID, staffID, custID);
	        sups.add(desc);
        }
        } catch (SQLException e) {
            System.out.println("failed: Cannot get the id " + e);
        }
        return sups;
}
    
  //select a data
    public static Description getDescriptionById(int descid) {
         Description sup = new Description();
        
         try {
        con = ConnectionManager.getConnection();
         ps=con.prepareStatement("select * from description where descid=?");

         ps.setInt(1, descid);
         ResultSet rs = ps.executeQuery();
             
         if (rs.next()) {
         sup.setDescid(rs.getInt("descid"));
         sup.setDescname(rs.getString("descname"));
         sup.setDescdate(rs.getDate("descdate"));
         sup.setForumID(rs.getInt("forumID"));
         sup.setCustID(rs.getInt("custID"));
         sup.setStaffID(rs.getString("staffID"));
         }
         } catch (SQLException e) {
             System.out.println("failed: Cannot get the id " + e);
         }
         return sup;
        }
    
	    public static int getDescriptionId() {
	    	int descid = 0;
	    	try {
	    	con = ConnectionManager.getConnection();
	    	ps = con.prepareStatement("select descid from description order by descid desc limit 1");
	    	ResultSet rs = ps.executeQuery();
	    	if(rs.next()){
	    	descid = rs.getInt("descid");
	    	}
	    	}
	    	catch(SQLException e) {
	    	e.printStackTrace();
	    	}
	    	return descid;
	    	}
    
	    
  //update
    public void updateDescription(Description bean) {
    	descid = bean.getDescid();
    	descname = bean.getDescname();
		descdate = bean.getDescdate();
		forumID = bean.getForumID();
		custID = bean.getCustID();
		staffID = bean.getStaffID();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String bdate = dateFormat.format(descdate);
        
        String searchQuery = "UPDATE booking SET descname='" + descname + "', descdate= '" + java.sql.Date.valueOf(bdate) + "',  forumID='" + forumID + "', staffID='" + staffID +"', custID='" + custID +"' WHERE descid= '" + descid + "'";
        System.out.println(searchQuery);
        try {
        con = ConnectionManager.getConnection();
        stmt = con.createStatement();
        stmt.executeUpdate(searchQuery);
        } catch (SQLException e) {
            System.out.println("failed: tak boleh update data " + e);
        }
        }
    
    public void deleteDecription(int descid) {
        try {
        con = ConnectionManager.getConnection();
        ps=con.prepareStatement("delete from description where descid=?");
        ps.setInt(1, descid);
        ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("failed: tak boleh delete data customer " + e);
        }
       }
 }               
