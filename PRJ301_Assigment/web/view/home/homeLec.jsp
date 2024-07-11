<%-- 
    Document   : homeLec
    Created on : Jul 2, 2024, 9:18:01 PM
    Author     : AD
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </head>
    <body> 
        <div class="container">
            <div class="row">
                <div class="col">
                    <c:if test="${sessionScope.user ne null}">
                        Hello: ${sessionScope.user.displayname}
                        <br/>
                        <a href="${pageContext.request.contextPath}/logout">logout</a>
                        <br/>
                        <a href="${pageContext.request.contextPath}/home/feature">homepage</a>
                    </c:if>
                </div>
                <div class="col">
                    FAP FOR LECTURER
                </div>
                <div class="col">
                    
                </div>
            </div>
            <div class="row">
                <div>
                    
                </div>
            </div>
        </div>
</body>
</html>
