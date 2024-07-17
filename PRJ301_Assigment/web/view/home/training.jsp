<%-- 
    Document   : training
    Created on : Jul 17, 2024, 7:14:14 AM
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
        <h2>Create Account Student</h2>
        <form action="create" method="POST">
            Displayname: <input type="text" name="displayname"/><br>
            Student ID: <input type="text" name="uid"/><br>
            Username: <input type="text" name="username"/><br>
            Password: <input type="text" name="password"/><br>
            Email: <input type="email" name="email"/>
            <p class="text-center mt-3" style="color: red">${mess}</p>
            <input type="submit" value="submit"/>
        </form>

    </body>
</html>
