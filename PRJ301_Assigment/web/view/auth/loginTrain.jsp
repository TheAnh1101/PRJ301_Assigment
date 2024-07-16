<%-- 
    Document   : loginTrain
    Created on : Jul 16, 2024, 5:09:04 AM
    Author     : AD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="training" method="POST">
            <h1>LOGIN FOR TRAINING</h1>
            Username: <input type="text" name="username"/><br> 
            Password: <input type="text" name="password"/><br>
            <p class="text-center mt-3" style="color: red">${error}</p>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
