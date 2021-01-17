package dao;

 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import connection.ConnectionManager;
import model.Customer;
import model.Staff;

 

public class StaffDAO {

 

    //declarations
        
        String staffID,sName,sNum,sPassword,adminID;
        static Connection con = null;
        static ResultSet rs = null;
        static PreparedStatement ps=null;
        static Statement stmt=null;
        
        
        //add data
        public void addStaff(Staff bean)
        {
            //get values
            staffID = bean.getStaffID();    
            sName = bean.getsName();
            sNum = bean.getsNum();
            sPassword = bean.getsPassword();
            adminID = bean.getAdminID();
        
            try 
            {
                //step 2: create connection
                con = ConnectionManager.getConnection();
                
                //step3 : create statement - using preparedStatement
                ps=con.prepareStatement("insert into staff(staffID,sName,sNum,sPassword)values(?,?,?,?)");
                ps.setString(1,staffID);
                ps.setString(2,sName);
                ps.setString(3,sNum);
                ps.setString(4,sPassword);
                //ps.setString(5,adminID);
                
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
        
        
        
        static Connection currentCon = null;
        
        //list
        public static List<Staff> getAllStaff() 
        {
            List<Staff> sups = new ArrayList<Staff>();
            try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            ResultSet rs = stmt.executeQuery("select * from staff order by staffID DESC");
            while (rs.next()) {
            Staff staff = new Staff();
            staff.setStaffID(rs.getString("staffID"));
            staff.setsName(rs.getString("sName"));
            staff.setsNum(rs.getString("sNum"));
            staff.setsPassword(rs.getString("sPassword"));
            //staff.setAdminID(rs.getString("adminID"));
            sups.add(staff);
            }
            } catch (SQLException e) {
                System.out.println("failed: cannot get all data " + e);
            }
            return sups;
            }

 

        
        public static Staff getStaffById(String staffID) {
             Staff sup = new Staff();
            
             try {
             currentCon = ConnectionManager.getConnection();
             ps=currentCon.prepareStatement("select * from staff where staffID=?");

 

             ps.setString(1, staffID);
             ResultSet rs = ps.executeQuery();
             
             if (rs.next()) {
             sup.setStaffID(rs.getString("staffID"));
             sup.setsName(rs.getString("sName"));
             sup.setsNum(rs.getString("sNum"));
	         sup.setsPassword(rs.getString("sPassword"));
	         //sup.setAdminID(rs.getString("adminID"));

             }
             } catch (SQLException e) {
                 System.out.println("failed: cannot get id " + e);
             }
             return sup;
            }
        
        //update
        public void updateStaff(Staff bean) {
        	staffID = bean.getStaffID();    
        	sName = bean.getsName();
            sNum = bean.getsNum();
            sPassword = bean.getsPassword();
            //adminID = bean.getAdminID();
            String searchQuery = "UPDATE staff SET sName= '" + sName + "', sNum='" + sNum + "', sPassword='" + sPassword + "' WHERE staffID= '" + staffID + "'";
            try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            stmt.executeUpdate(searchQuery);
            } catch (SQLException e) {
                System.out.println("failed: cannot update data " + e);
            }
            }
        
        //delete 
        public void deleteStaff(String staffID) {
         try {
         currentCon = ConnectionManager.getConnection();
         ps=currentCon.prepareStatement("delete from staff where staffID=?");
         ps.setString(1,staffID);
         ps.executeUpdate();
         } catch (SQLException e) {
             System.out.println("failed: cannot delete staff data " + e);
         }
        }
        
        public static Staff login(Staff bean) {
    		// preparing some objects for connection 		
    				Statement stmt = null;
    				String staffID = bean.getStaffID();
    				String sName = bean.getsName();
    				String sPassword = bean.getsPassword();
    				String searchQuery = "select * from staff where staffID='" 
    				+ staffID + "' AND sPassword='" + sPassword + "'";
    				//------prepared statement
    				
    				try {
    					// connect to DB
    					currentCon = ConnectionManager.getConnection();
    					stmt = currentCon.createStatement();
    					rs = stmt.executeQuery(searchQuery);
    					boolean more = rs.next();
    					// if user does not exist
    					if (!more) {
    						System.out.println("Sorry, you are not a registered user! " + "Please sign up first");
    						bean.setValid(false);
    					}
    					// if user exists
    					else if (more) {
    						sName = rs.getString("sName");
    						staffID = rs.getString("staffID");
    						sPassword = rs.getString("sPassword");
    						bean.setsName(sName);
    						bean.setStaffID(staffID);
    						bean.setsPassword(sPassword);
    						
    						bean.setValid(true);
    					}
    				} catch (Exception ex) {
    					System.out.println("Log In failed: An Exception has occurred! " + ex);
    				} // some exception handling
    				finally {
    					if (rs != null) {
    						try {
    							rs.close();
    						} catch (Exception e) { }
    						rs = null;
    					}
    					if (stmt != null) {
    						try {
    							stmt.close();
    						} catch (Exception e) { }
    						stmt = null;
    					}
    					if (currentCon != null) {
    						try {
    							currentCon.close();
    						} catch (Exception e) { }
    						currentCon = null;
    					}
    								}
    				return bean;
        }
    				
    				public static Staff adminLogin(Staff bean) {
    		    		// preparing some objects for connection 		
    		    				Statement stmt = null;
    		    				String adminID = bean.getAdminID();
    		    				String sName = bean.getsName();
    		    				String sPassword = bean.getsPassword();
    		    				String sql = "select * from staff where adminID='" 
    		    				+ adminID + "' AND sPassword='" + sPassword + "'";
    		    				//------prepared statement
    		    				
    		    				try {
    		    					// connect to DB
    		    					currentCon = ConnectionManager.getConnection();
    		    					stmt = currentCon.createStatement();
    		    					rs = stmt.executeQuery(sql);
    		    					boolean more = rs.next();
    		    					// if user does not exist
    		    					if (!more) {
    		    						System.out.println("Sorry, you are not a registered user! " + "Please sign up first");
    		    						bean.setValid(false);
    		    					}
    		    					// if user exists
    		    					else if (more) {
    		    						sName = rs.getString("sName");
    		    						adminID = rs.getString("adminID");
    		    						sPassword = rs.getString("sPassword");
    		    						bean.setsName(sName);
    		    						bean.setAdminID(adminID);
    		    						bean.setsPassword(sPassword);
    		    						
    		    						bean.setValid(true);
    		    					}
    		    				} catch (Exception ex) {
    		    					System.out.println("Log In failed: An Exception has occurred! " + ex);
    		    				} // some exception handling
    		    				finally {
    		    					if (rs != null) {
    		    						try {
    		    							rs.close();
    		    						} catch (Exception e) { }
    		    						rs = null;
    		    					}
    		    					if (stmt != null) {
    		    						try {
    		    							stmt.close();
    		    						} catch (Exception e) { }
    		    						stmt = null;
    		    					}
    		    					if (currentCon != null) {
    		    						try {
    		    							currentCon.close();
    		    						} catch (Exception e) { }
    		    						currentCon = null;
    		    					}
    		    								}
    		    				return bean;
}}
                