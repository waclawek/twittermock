<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 22.08.2020
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2>Welcome to twitter mock</h2>
    <div>Logowanie</div>
    <div>
        <form action="${pageContext.request.contextPath}/authentication" method="post">
            <div>
                <label for="username">User name : </label>
                <input type="text" name="username" id="username" />
            </div>
            <div>
                <label for="password">Password : </label>
                <input type="password" name="password" id="password" />
            </div>
            <div>
                <input type="submit" value="login">
            </div>
        </form>
    </div>
    <hr/>
    <div class="container">
        <h2><a href="${pageContext.request.contextPath}/register">Register new user</a> </h2>
    </div>


</div>

</body>
</html>
