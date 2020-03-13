<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 09.11.2019
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../resources/css/Style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<div id="wrapper" class="toggled">

    <!-- Sidebar -->
    <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <li class="sidebar-brand">
                <a href="#">
                    Studentus
                </a>
            </li>
            <li>
                <a href="/schedule">Schedule</a>
            </li>
        </ul>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div class="container-fluid">

            <div class="container">
                <h1>Edit Profile</h1>
                <hr>
                <div class="row">

                    <div class="col-md-3">
                        <div class="text-center">
                            <img src="" id ="pictureForm" class="avatar img-circle" alt="avatar">
                        </div>
                    </div>



                    <!-- edit form column -->
                    <div class="col-md-9 personal-info">
                        <div class="form-group">
                            <label class="col-lg-3 control-label">Name:</label>
                            <div class="col-lg-8">
                                .....
                            </div>
                        </div>

                            <label class="col-lg-3 control-label">Email:</label>
                            <div class="col-lg-8">
                                .......
                            </div>
                            <label class="col-md-3 control-label">Password:</label>
                            <div class="col-md-8">
                                ....
                            </div>
                            <label class="col-md-3 control-label">Confirm password:</label>
                            <div class="col-md-8">
                                ............
                            </div>
                            <label class="col-md-3 control-label"> Other Info</label>
                            <div class="col-md-8">
                                ............
                            </div>
                            <div>
                                <button>Send Request</button>
                            </div>

                    </div>
                </div>

            </div>

            <hr>

        </div>

    </div>

    <!-- /#page-content-wrapper -->

</div>
<!-- /#wrapper -->
</form>
</body>
</html>
