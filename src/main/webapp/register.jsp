<html>
<head>
    <title>Register Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>register to twitter mock</h1>
    <form action="${pageContext.request.contextPath}/register" method="post">
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