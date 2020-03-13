<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 09.11.2019
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
    <link rel="stylesheet" type="text/css" href="../../resources/css/Style.css">
    <link rel="stylesheet" type="text/css" href="../../resources/css/tutorsGrid.css">
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
                    <tr th:each="tutor : ${tutors}">
                        <td th:text="${tutor.name}">...</td>
                    </tr>
                </div>
        </div>

    </div>

    <!-- /#page-content-wrapper -->

</div>
<!-- /#wrapper -->
</form>
</body>
</html>
