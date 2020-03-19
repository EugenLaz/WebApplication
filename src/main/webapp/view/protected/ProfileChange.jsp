<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="text"/>

<html>
<head>
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
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
                <a href="/loadChangePage">
                    Start Bootstrap
                </a>
            </li>
            <li>
                <a href="/loadRequests">My Requests</a>
            </li>
            <li>
                <a href="/tutorList">List of tutors</a>
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
                    <!-- left column -->
                    <div class="col-md-3">
                        <div class="text-center">
                            <img src="web-resources/profilePictures/${user.username}.png" id="pictureForm"
                                 class="avatar img-circle" alt="avatar">
                            <h6>Upload a different photo...</h6>
                            <form method="POST" enctype="multipart/form-data" action="/uploadFile">
                                <table>
                                    <tr>
                                        <td>
                                        <td><input type="file" name="file" value="Upload NEW PHOTO"/></td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td><input type="submit" value="Upload"/></td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                    </div>

                    <!-- edit form column -->
                    <div class="col-md-9 personal-info">
                        <form class="form-horizontal" action="/changesProcess" role="form">
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Name:</label>
                                <div class="col-lg-8">
                                    <input class="form-control" name="Name" type="text" value="${user.name}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Email:</label>
                                <div class="col-lg-8">
                                    <input class="form-control" name="Email" type="text" value="${user.email}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">About:</label>
                                <div class="col-lg-8">
                                    <input class="form-control" name="About" type="text" value="${user.personalInfo}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label"></label>
                                <div class="col-md-8">
                                    <input type="submit" class="btn btn-primary" value="Save Changes">
                                    <span></span>
                                    <input type="reset" class="btn btn-default" value="Cancel">
                                </div>
                            </div>


                        </form>
                    </div>
                </div>
            </div>
            <hr>

        </div>
    </div>


</div>
</body>
</html>