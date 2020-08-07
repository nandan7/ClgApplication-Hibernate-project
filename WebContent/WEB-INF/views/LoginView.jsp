<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login</title>
    <link rel="stylesheet" href="./css/style.css">
</head>
<body>
 <nav>
        <img src="./assets/klu.png" alt="logo" />
     
        <ul>
        <li> <a href="${pageContext.request.contextPath}/admin">Admin</a></li>
            <li> <a href="${pageContext.request.contextPath}/login">Login</a></li>
            <li> <a href="${pageContext.request.contextPath}/signup">Sign Up</a></li>
        </ul>
    </nav>
    <div class="login-form">
        <div class="title">LOGIN</div>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <label class="label" for="email">Email</label>
            <input type="text" name="email" id="email">
            <label class="label" for="password">Password</label>
            <input type="password" name="password" id="password">
            <button class="button" type="submit">Login</button>
        </form>
    </div>
</body>
</html>