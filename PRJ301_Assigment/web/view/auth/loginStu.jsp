<%-- 
    Document   : loginStu
    Created on : Jul 2, 2024, 9:10:29 PM
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
        <form action="student" method="POST">
            <h1>LOGIN FOR STUDENT</h1>
            Username: <input type="text" name="username"/><br> 
            Password: <input type="password" name="password"/><br>
            <p class="text-center mt-3" style="color: red">${error}</p>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
