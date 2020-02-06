
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/login.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


</head>
<body>
<div class="login-container">
    <section class="login" id="login">
        <header>
            <h2>Application Name</h2>
            <h4>Login</h4>
        </header>
        <form class="login-form" method="post">
            <input type="text" name="j_username" class="login-input" placeholder="User" required autofocus/>
            <input type="password" name="j_password" class="login-input" placeholder="Password" required/>
            <div class="submit-container">
                <button type="submit" class="login-button">SIGN IN</button>
            </div>
        </form>
    </section>
</div>
</body>
</html>