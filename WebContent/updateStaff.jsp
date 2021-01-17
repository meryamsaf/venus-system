<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%@ include file="navbar-admin.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>

<body>
 
     <a href="ListStaffController?action=viewStaff&staffID=1">List Staff</a>
     <a href="AddStaffController?action=viewStaff&staffID=1">Add Staff</a>
                
     <div class="container"><h1>Update staff</h1></div>
     <form action="UpdateStaffController" style="border:1px solid #ccc" method="post">
     <div class="container">
   
     <label for="staff ID"><b>Staff ID</b></label><br>
     <input type="text" name="staffID" value="<c:out value="${staff.staffID}"/>" readonly/>
     <br><br>
    
     <label for="name"><b>Name</b></label><br>
     <input type="text" name="sName" value="<c:out value="${staff.sName}"/>" required>
     <br><br>

     <label for="phone"><b>Phone number</b></label><br>
     <input type="text" name="sNum" value="<c:out value="${staff.sNum}"/>" required>
     <br><br>
    
     <div class="clearfix">
        <a href="ListStaffController?action=viewStaff&staffID=1" class="w3-btn w3-red w3-round-large" >Cancel</a>
        <input type="submit" value="Update" class="w3-btn w3-green w3-round-large" onclick="return confirm('Are you sure want to update?')">
     </div>
  </div>
</form>

</body>
</html>