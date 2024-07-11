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
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="../common/homePage.jsp"></jsp:include>
            <br> 
            FAP FPTU
            <table border = 1px>

            <c:if test="${sessionScope.user.lecturer ne null && sessionScope.user.student eq null}">
                <a href="${pageContext.request.contextPath}/exam/lecturer">View Course</a>
                
            </c:if>
        </table>

    </body>
</html>
