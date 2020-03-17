<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="text"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../resources/css/RequestTable.css">
    <link rel="stylesheet" type="text/css" href="../../resources/css/Style.css">
    <title>Title</title>
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
            <div class="container-table100">
                <div class="wrap-table100">
                    <div class="table100">
                        <table>
                            <thead>
                            <tr class="table100-head">
                                <th class="column1">ID</th>
                                <th class="column2">Requestor</th>
                                <th class="column3">Place</th>
                                <th class="column4">Price</th>
                                <th class="column5">Message</th>

                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="request" items="${requests}">
                                    <tr>
                                        <td class="column1">${request.requestID}</td>
                                        <td class="column2">${request.studentID}</td>
                                        <td class="column3">${request.place}</td>
                                        <td class="column4">${request.pricePerHour}/hour</td>
                                        <td class="column5">${request.message}</td>
                                    </tr>
                                    <tr>

                                        <td class="column1"><a href="/acceptRequest/${request.requestID}">ACCEPT</a></td>
                                        <td class="column2"><a href="/declineRequest/${request.requestID}">DECLINE</a></td>
                                        <td class="column3"></td>
                                        <td class="column4"></td>
                                        <td class="column5"></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>



        </div>

    </div>


</div>

</body>
</html>
