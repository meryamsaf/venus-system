<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%@ page import="java.sql.*" %>
    <%@ include file="navbar-staff.jsp" %>
<!DOCTYPE html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Venus Pet</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="style.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

         

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

              

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        
                        <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
                    </div>
                     
                    <!-- Content Row -->
                    <div class="row">

                         <div class="col mb-4">

                            <!-- Illustrations -->
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">Analysis Data</h6>
                                </div>
                                <div class="card-body">
                                    
                                    <p>This is Venus Pet System for Cat Hotel & Spa Services </p>
                                    
                                       
                                         <!-- Earnings (Monthly) Card Example -->
                        <div class="col mb-4">
                            <div class="card border-left-primary shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                Total Customer  </div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"><%
											try
											{
											Class.forName("com.mysql.jdbc.Driver").newInstance();
											Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/venus","root","");
											Statement st=con.createStatement();
											String strQuery = "SELECT COUNT(custID) FROM customer";
											ResultSet rs = st.executeQuery(strQuery);
											String custTotal="";
											while(rs.next()){
											custTotal = rs.getString(1);
											out.println(custTotal);
											}
											}
											catch (Exception e){
											e.printStackTrace();
											}
											%></div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Earnings (Monthly) Card Example -->
                       <div class="col mb-4">
                            <div class="card border-left-success shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                                Total Booking</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"><%
											try
											{
											Class.forName("com.mysql.jdbc.Driver").newInstance();
											Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/venus","root","");
											Statement st=con.createStatement();
											String strQuery = "SELECT COUNT(bookingID) FROM booking";
											ResultSet rs = st.executeQuery(strQuery);
											String bookingTotal="";
											while(rs.next()){
											bookingTotal = rs.getString(1);
											out.println(bookingTotal);
											}
											}
											catch (Exception e){
											e.printStackTrace();
											}
											%></div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        
                                        <div class="col-auto">
                                            <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                                </div>
                            </div>
                            
                            
                   </div>
                </div>
                
               
                
               </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->


         

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>
<!-- Custom scripts for all pages-->
    <script src="javascript.js"></script>
    
    

</body>

</html>