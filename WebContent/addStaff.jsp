<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Staff</title>

<script>
function myFunction()
{
	var checkBox = document.getElementById("adminID");
	if (checkBox.checked == true)
	{
		alert("Enter your admin id:");
	}
}
</script>


</head>
<body>
    <a href="ListStaffController?action=viewStaff&staffID=1">List staff</a>
    <a href="AddStaffController?action=viewStaff&staffID=1">Add Staff</a>
                
    
    <form action="AddStaffController" method="post">
    <h2>Add staff</h2>
    
    	Enter your id<input type="text" name="staffID" required><br>
    	
        Enter your name<input type="text" name="sName" required><br>

        Enter your phone number<input type="text" name="sNum" required><br>
        
        Enter your password<input type="text" name="sPassword" required><br>
        
        <!--  Are you an admin?
        <br>
        <input type="checkbox" id="adminID" name="adminID" value="adminID" onclick="myFunction()">
        <label for="adminID">Yes,I am an admin.</label><br> 
        -->

    <input type="submit" value="Submit" class="Register" >
    </form>

 

</body>
</html>


