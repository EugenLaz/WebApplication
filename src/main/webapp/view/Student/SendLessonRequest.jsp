<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<html xmlns:th="https://www.thymeleaf.org">
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/Style.css">
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
                <form method="get"
                           action="/sendRequest">
                    <input type="number" placeholder="Price" name="price"/>
                    <input type="text" placeholder="Place" name="place"/>
                    <input type="datetime-local" placeholder="Date&Time" name="dateTime"/>
                    <input type="text" placeholder="Additional INFO" name="description"/>
                    <input type="submit"value="submit"/>
                </form>
                <hr>
            </div>
        </div>


        </div>

    </div>

    <!-- /#page-content-wrapper -->

</div>
<!-- /#wrapper -->
</form>
</body>
</html>
