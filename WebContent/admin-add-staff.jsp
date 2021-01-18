<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%@ include file="navbar-admin.jsp" %>
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
 	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="style.css" rel="stylesheet">
 <style type="text/css">
        .box {
            color: black;
            display: none;
            margin-top: 20px;
        }

        .check {
            background: #ffffff;
        }
    </style>
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

                     <!-- Content Row -->
                    <div class="row">

                        <!-- Content Column -->
                        <div class="col mb-4">

                            <!-- Project Card Example -->
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">Add Staff</h6>
                                </div>
                                <div class="card-body">
                                     <form class="user" action="AddStaffController" method="post">
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" name="staffID"
                                        placeholder="Staff ID" required>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" name="sName"
                                        placeholder="Name" required>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" name="sNum"
                                        placeholder="Phone Number" required>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" name="sPassword"
                                        placeholder="Password">
                                </div>
                                 Are you an admin?
						        <br>
						        <input type="checkbox" name="colorCheckbox" value="check"> Yes,I am an admin.
						        <div class="check box">
						         <input type="text" class="form-control form-control-user" name="adminID"
                                        placeholder="Admin ID">
						        </div><br>
						        <input type="submit" value="Submit" class="btn btn-primary btn-user btn-block" onclick="confirmAdd()"><br>
  								
                              
                            </form>
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

   

    <script src="js.js"></script>
<script>
    function confirmAdd()
    {
      var x = confirm("Are you sure you want to add?");
      if (x)
          return true;
      else
        return false;
    }
    </script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('input[type="checkbox"]').click(function() {
                var inputValue = $(this).attr("value");
                $("." + inputValue).toggle();
            });
        });
    </script>

</body>
</html>