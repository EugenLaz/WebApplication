<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="text"/>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../resources/css/Style.css">
    <link rel="stylesheet" type="text/css" href="../../resources/css/Schedule.css.css">
<%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">--%>

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
            <form action = "/scheduleProcess" method="GET">
                <input type="date" name = "chosenDate" min="2019-01-01" >
                <input type="submit" >
            </form>
            <p/>
            <p/>
            <table>
                    <c:forEach var="o" items="${lessons}">
                        <tr>
                            <th>${o.time}</th>
                            <td colspan="3" class="stage-earth">${o.message}</td>
                        </tr>
                        <tr>
                            <th></th>
                            <td class="stage-mercury">Price:<br>${o.pricePerHour}</td>
                            <td class="stage-venus">Place:<br>${o.place}</td>
                            <td class="stage-saturn">Time:<br>${o.time}</td>
                        </tr>
                    </c:forEach>
          </table>

        </div>
    </div>


</div>
</body>
</html>
