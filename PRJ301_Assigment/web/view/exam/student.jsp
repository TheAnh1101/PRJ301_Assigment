<%-- 
    Document   : student
    Created on : Jul 16, 2024, 2:16:34 AM
    Author     : AD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="../common/homePage.jsp"></jsp:include>
        <c:if test="${requestScope.exams eq null}">
        <form action="student" method="POST"> 
            <input type="hidden" name="sid" value="${param.sid}"/>
            Course <select name="cid">
                <c:forEach items="${requestScope.courses}" var="c">
                    <option value="${c.id}">${c.name}</option>
                </c:forEach>
            </select>
            <input type="submit" value="View"/>
        </form>
        </c:if>
        <c:if test="${requestScope.exams ne null}">
            <form action="grade" method="GET">
                <input type="hidden" name="lid" value="${param.lid}"/>
                <input type="hidden" name="cid" value="${param.cid}"/>
                <c:forEach items="${requestScope.exams}" var="e">
                    <input type="checkbox" name="eid" value="${e.id}"/> ${e.assessment.name} - ${e.assessment.subject.name} - ${e.date} - ${e.duration} minutes <br/>
                </c:forEach>
                    <input type="submit" value="View"/>
            </form>
        </c:if>
    </body>
</html>
