<%-- 
    Document   : homePage
    Created on : Jul 11, 2024, 8:35:56 PM
    Author     : AD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }
            .menu {
                background-color: yellow;
                height: 50px; /* Chỉnh chiều cao của thanh menu */
                display: flex;
                justify-content: center;
                align-items: center;
                position: fixed;
                top: 0;
                width: 100%;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            }
            .menu a {
                margin: 0 15px;
                color: #333;
                text-decoration: none;
                font-weight: bold;
            }
            .menu a:hover {
                text-decoration: underline;
            }
            .content {
                margin-top: 60px; /* Khoảng cách để tránh trùng với thanh menu */
                padding: 20px;
            }
        </style>
    </head>
    <body>
        <div class="menu">
            <c:if test="${sessionScope.user ne null}">
                <span>Hello: ${sessionScope.user.displayname}</span>
                <a href="${pageContext.request.contextPath}/logout">Logout</a>
                <a href="${pageContext.request.contextPath}/home/feature">Homepage</a>
            </c:if>
            <c:if test="${sessionScope.user eq null}">
                <a href="${pageContext.request.contextPath}/login">Login</a> 
            </c:if>
            <a href="${pageContext.request.contextPath}/password/verify">Change Password</a>
        </div>
        <div class="content">
            <!-- Nội dung của trang web -->
        </div>
    </body>
</html>
