<%-- 
    Document   : loginLec
    Created on : Jul 2, 2024, 9:14:32 PM
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
        <form action="login" method="POST">
            <h1>LOGIN FOR LECTURER</h1>
            Username: <input type="text" name="username"/><br> 
            Password: <input type="text" name="password"/><br>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
