<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="text"/>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../../resources/css/Style.css">
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

                    <div class="col-md-3">
                        <div class="text-center">
                            <img src="web-resources/profilePictures/${tutor.username}.png" id="pictureForm"
                                 class="avatar img-circle" alt="avatar">
                        </div>
                    </div>


                    <div class="col-md-9 personal-info">
                        <div>${tutor.username}</div>
                        <div>${tutor.name}</div>
                        <div>${tutor.personalInfo}</div>
                    </div>
                </div>

            </div>

            <hr>
            <div class="row">
                <form method="post"
                      action="/sendRequest/${tutor.username}">
                    <input type="number" placeholder="Price" name="price"/>
                    <input type="text" placeholder="Place" name="place"/>
                    <input type="date" placeholder="Date" name="date"/>
                    <input type="time" name="time" required placeholder="Time">
                    <input type="text" placeholder="Additional INFO" name="description"/>

                    <div><input type="submit" value="submit"/></div>
                </form>
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
