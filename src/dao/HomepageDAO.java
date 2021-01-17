package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionManager;
import model.Homepage;

public class HomepageDAO {

	//declarations
    int vID;
    String vName,vLocation,vPhone,vDetails,staffID;
    static Connection con = null;
    static ResultSet rs = null;
    static PreparedStatement ps=null;
    static Statement stmt=null;
        
        
    //add data
    public void addHomepage(Homepage bean)
    {
        //get values
        vID = bean.getvID();    
        vName = bean.getvName();
        vLocation = bean.getvLocation();
        vPhone = bean.getvPhone();
        vDetails = bean.getvDetails();
        staffID = bean.getStaffID();
        try 
        {
            //step 2: create connection
            con = ConnectionManager.getConnection();
            
            //step3 : create statement - using preparedStatement
            ps=con.prepareStatement("insert into homepage(vName,vLocation,vPhone,vDetails,staffID)values(?,?,?,?,?)");
            ps.setString(1,vName);
            ps.setString(2,vLocation);
            ps.setString(3,vPhone);
            ps.setString(4,vDetails);
            ps.setString(5,staffID);
            
            //step 4: execute statement
            ps.executeUpdate();
            //step 5: close connection
            con.close();
        }
        catch (Exception ex) 
        {
            System.out.println("Failed: An Exception has occurred! " + ex);
        }
    }
    
    
    
    static Connection currentCon = null;
    
    //list data
    public static List<Homepage> getAllHomepage() 
    {
        List<Homepage> sups = new ArrayList<Homepage>();
        try {
        currentCon = ConnectionManager.getConnection();
        stmt = currentCon.createStatement();
        ResultSet rs = stmt.executeQuery("select * from homepage order by vID DESC");
        while (rs.next()) {
        Homepage homepage = new Homepage();
        homepage.setvID(rs.getInt("vID"));
        homepage.setvName(rs.getString("vName"));
        homepage.setvLocation(rs.getString("vLocation"));
        homepage.setvPhone(rs.getString("vPhone"));
        homepage.setvDetails(rs.getString("vDetails"));
        homepage.setStaffID(rs.getString("staffID"));
        sups.add(homepage);
        }
        } catch (SQLException e) {
            System.out.println("failed: tak boleh get data all " + e);
            }
            return sups;
    }

    //select a data
    public static Homepage getHomepageById(int vID) {
         Homepage sup = new Homepage();
        
         try {
         currentCon = ConnectionManager.getConnection();
         ps=currentCon.prepareStatement("select * from homepage where vID=?");

         ps.setInt(1, vID);
         ResultSet rs = ps.executeQuery();
             
         if (rs.next()) {
         sup.setvID(rs.getInt("vID"));
         sup.setvName(rs.getString("vName"));
         sup.setvLocation(rs.getString("vLocation"));
         sup.setvPhone(rs.getString("vPhone"));
         sup.setvDetails(rs.getString("vDetails"));
         sup.setStaffID(rs.getString("staffID"));
         }
         } catch (SQLException e) {
             System.out.println("Failed: Cannot get the id " + e);
         }
         return sup;
        }
    
    //update
    public void updateHomepage(Homepage bean) {
        vID = bean.getvID();
        vName = bean.getvName();
        vLocation = bean.getvLocation();
        vPhone = bean.getvPhone();
        vDetails = bean.getvDetails();
        staffID = bean.getStaffID();
        String searchQuery = "UPDATE homepage SET vName= '" + vName + "', vLocation='" + vLocation + "', vPhone='" + vPhone + "', vDetails='" + vDetails +"', staffID='" + staffID +"' WHERE vID= '" + vID + "'";
        try {
        currentCon = ConnectionManager.getConnection();
        stmt = currentCon.createStatement();
        stmt.executeUpdate(searchQuery);
        } catch (SQLException e) {
            System.out.println("Failed: tak boleh update data " + e);
        }
        }
    
    //delete 
    public void deleteHomepage(int vID) {
     try {
     currentCon = ConnectionManager.getConnection();
     ps=currentCon.prepareStatement("delete from homepage where vID=?");
     ps.setInt(1,vID);
     ps.executeUpdate();
     } catch (SQLException e) {
         System.out.println("Failed: Cannot delete homepage " + e);
     }
    }
    
    public static List<Homepage> getHomepageDetails() 
    {
        List<Homepage> sups = new ArrayList<Homepage>();
        try {
        currentCon = ConnectionManager.getConnection();
        stmt = currentCon.createStatement();
        String vStatus="True";
        ResultSet rs = stmt.executeQuery("select * from homepage where vStatus= '"+vStatus+"'");
        while (rs.next()) {
        Homepage homepage = new Homepage();
        
        homepage.setvID(rs.getInt("vID"));
        homepage.setvName(rs.getString("vName"));
        homepage.setvLocation(rs.getString("vLocation"));
        homepage.setvPhone(rs.getString("vPhone"));
        homepage.setvDetails(rs.getString("vDetails"));
        homepage.setStaffID(rs.getString("staffID"));
        sups.add(homepage);
        }
        } catch (SQLException e) {
            System.out.println("failed: tak boleh get data all " + e);
            }
            return sups;
    }
}
