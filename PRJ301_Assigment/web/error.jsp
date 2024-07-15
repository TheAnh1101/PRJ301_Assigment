<%-- 
    Document   : error
    Created on : Jul 14, 2024, 11:23:16 PM
    Author     : AD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h2 style="color:red">An unexpected error has been occurred! </h2><br/>
        <%= exception %>  
        <br>
        <h2>Please back to <a href="${pageContext.request.contextPath}/home/feature"> Home Page</a></h2>
    </body>
</html>
