<%-- 
    Document   : homePage
    Created on : Jul 11, 2024, 8:35:56 PM
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
        <table border = 1px>
            <tr>
                <td>
            <c:if test="${sessionScope.user ne null}">
                Hello: ${sessionScope.user.displayname}
                <br/>
                <a href="${pageContext.request.contextPath}/logout">Logout</a>
                <br/>
                <a href="${pageContext.request.contextPath}/home/feature">homepage</a>
            </c:if>
            <c:if test="${sessionScope.user eq null}">
                <a href="${pageContext.request.contextPath}/login">login</a> 
            </c:if>

            <br/>
            <a href="${pageContext.request.contextPath}/view/detail">View Information</a>
            <br/>
            <a href="${pageContext.request.contextPath}/changepass">Change Password</a>
            <br/>
            <a href="${pageContext.request.contextPath}/feedback/send">send a feedback</a>
        </td>
    </tr>
</table>
</body>
</html>
