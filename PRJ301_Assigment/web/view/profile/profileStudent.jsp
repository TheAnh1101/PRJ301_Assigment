<%-- 
    Document   : profileStudent
    Created on : Jul 14, 2024, 11:51:04 PM
    Author     : AD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Student</title>
    </head>
    <body>
        <jsp:include page="../common/homePage.jsp"></jsp:include>
        <c:if test="${requestScope.user ne null}">
            ${param.lid}
            ID: ${requestScope.user.id}<br>
            Name: ${requestScope.user.student.name}<br>
            Email: ${requestScope.user.email}<br>
            Gender: ${requestScope.user.student.gender?"Male":"Female"}<br>
            DOB: ${requestScope.user.student.dob}<br>
        </c:if>
        <c:if test="${requestScope.user eq null}">
            User does not exits!
        </c:if>

    </body>
</html>
