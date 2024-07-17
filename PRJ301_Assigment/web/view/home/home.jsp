<%-- 
    Document   : home
    Created on : Jul 11, 2024, 8:47:44 PM
    Author     : AD
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <style>
            .feature-links {
                text-align: center;
                margin-top: 50px;
            }
            .feature-links a {
                display: block;
                margin: 10px 0;
                text-decoration: none;
                color: #007bff;
                font-weight: bold;
            }
            .feature-links a:hover {
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <jsp:include page="../common/homePage.jsp"></jsp:include>
        <div class="feature-links">
            <c:if test="${sessionScope.user.lecturer ne null && sessionScope.user.student eq null}">
                <h2>FAP FPTU For Lecturer</h2>
                <input type="hidden" name="lid" value="${param.lid}"/>
                <a href="${pageContext.request.contextPath}/exam/lecturer">View Course</a>
                <a href="${pageContext.request.contextPath}/profile/lecturer?lid=${sessionScope.user.lecturer.id}">Profile</a>
                <a href="#">Blog</a>
            </c:if>
            <c:if test="${sessionScope.user.student ne null && sessionScope.user.lecturer eq null}">
                <h2>FAP FPTU For Student</h2>
                <a href="${pageContext.request.contextPath}/profile/student?sid=${sessionScope.user.student.id}">Profile</a>
                <a href="${pageContext.request.contextPath}/course/list">View List Course</a>
                <a href="${pageContext.request.contextPath}/exam/student">View Grade</a>
                <a href="#">Blog</a>
            </c:if>
        </div>
    </body>
</html>
