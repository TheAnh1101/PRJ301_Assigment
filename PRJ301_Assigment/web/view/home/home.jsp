<%-- 
    Document   : home
    Created on : Jul 11, 2024, 8:47:44 PM
    Author     : AD
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <jsp:include page="../common/homePage.jsp"></jsp:include>
            <br> 
            <table border = 1px>
            <c:if test="${sessionScope.user.lecturer ne null && sessionScope.user.student eq null}">
                FAP FPTU For Lecturer
                <br>
                <input type="hidden" name="lid" value="${sessionScope.user.lecturer.id}"/>
                <a href="${pageContext.request.contextPath}/exam/lecturer">View Course</a><br>
                <a href="${pageContext.request.contextPath}/view/profile">Profile</a><br>
                <a href="#">Blog</a>
            </c:if>
            <c:if test="${sessionScope.user.student ne null && sessionScope.user.lecturer eq null}" >
                FAP FPTU For Student
                <br>
                <a href="#">View List Course</a><br>
                <a href="#">View Score</a><br> 
                <a href="#">Blog</a><br>
                
            </c:if>    
        </table>

    </body>
</html>
