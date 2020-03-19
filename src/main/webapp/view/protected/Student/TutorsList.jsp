<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="text"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet" type="text/css" href="../../../resources/css/Style.css">
    <link rel="stylesheet" type="text/css" href="../../../resources/css/tutorsGrid.css">
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
            <table>
                <c:forEach var="o" items="${tutors}">
                    <div class="container">
                        <div>
                            <img src="web-resources/profilePictures/${o.username}.png"/>
                                ${o.name}
                            <a href="/openTutor/${o.username}">SEND APPLICATION</a>
                        </div>
                    </div>
                </c:forEach>
            </table>

        </div>

    </div>

    <!-- /#page-content-wrapper -->

</div>
<!-- /#wrapper -->
</body>
</html>
