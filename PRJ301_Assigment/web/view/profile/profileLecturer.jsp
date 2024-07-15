<%-- 
    Document   : profile
    Created on : Jul 14, 2024, 1:56:48 AM
    Author     : AD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Lecturer</title>
    </head>
    <body>
        <jsp:include page="../common/homePage.jsp"></jsp:include>
        <c:if test="${requestScope.user ne null}">
            ${param.lid}
            ID: ${requestScope.user.id}<br>
            Name: ${requestScope.user.lecturer.name}<br>
            Email: ${requestScope.user.email}<br>
            Gender: ${requestScope.user.lecturer.gender?"Male":"Female"}<br>
            DOB: ${requestScope.user.lecturer.dob}<br>
        </c:if>
        <c:if test="${requestScope.user eq null}">
            User does not exits!
        </c:if>

    </body>
</html>
