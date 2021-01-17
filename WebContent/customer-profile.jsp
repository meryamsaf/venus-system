<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%@ include file="navbar-customer.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Venus Pet System</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="style.css" rel="stylesheet">

</head>

<body id="page-top">

     <!-- Begin Page Content -->
     <div class="container-fluid">

          <!-- Content Row -->
         <div class="row">

             <!-- Content Column -->
             <div class="col mb-4">

                 <!-- Project Card Example -->
                 <div class="card shadow mb-4">
                     <div class="card-header py-3">
                         <h6 class="m-0 font-weight-bold text-primary">My Profile</h6>
                     </div>
                     <div class="card-body">
                          <form class="user" action="ListCustomerController" method="post">
                          
                    
                      <div class="form-group">
                      	<input type="text" class="form-control form-control-user" name="custID" 
                      	value="<c:out value="${cust.custID}"/>" placeholder="ID" readonly>
                      </div>
                      
                      <div class="form-group">
                          <input type="text" class="form-control form-control-user" id="cName"
                          value="<c:out value="${cust.cName}"/>"placeholder="Name" readonly>
                      </div>
                      
                      
                      
                      <div class="form-group">
                          <input type="number" class="form-control form-control-user" id="cNum"
                             value="<c:out value="${cust.cNum}"/>" placeholder="Phone Number" readonly>
                      </div>
                      
                      
                      
                      <div class="form-group">
                          <input type="text" class="form-control form-control-user" id="cEmail"
                              value="<c:out value="${cust.cEmail}"/>" placeholder="Email" readonly>
                      </div>
                      
                      
                      
                      <div class="form-group">
                          <input type="password" class="form-control form-control-user" id="cPassword"
                              value="<c:out value="${cust.cPassword}"/>" placeholder="Password" readonly>
                        </div>   
                     
                     
                     <!--  <input type="submit" value="Update Profile" class="btn btn-primary btn-user btn-block"><br>-->
                     
                     
                 </form>
                 <a href="DeleteCustomerController?action=delete&custID=<c:out value="${cust.custID}"/>">
                     	 <input type="submit" value="Delete Profile" class="btn btn-primary btn-user btn-block">
                     </a><br>
                     </div>
                 </div>

                 
             </div>
         </div>

     </div>
     <!-- /.container-fluid -->

 </div>
 </div>
 <!-- E
 nd of Main Content -->

    <script src="js.js"></script>

</body>
</html>