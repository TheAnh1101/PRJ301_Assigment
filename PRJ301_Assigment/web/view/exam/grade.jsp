<%-- 
    Document   : grade.jsp
    Created on : Jul 16, 2024, 2:26:05 AM
    Author     : AD
--%>

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
        <table border = 1px>
            <c:forEach items="${requestScope.exams}" var="e">
                <th>
                    <span style="color:red;">${e.assessment.name}</span>|
                    ${e.date} - ${e.assessment.weight}%
                </th>
            </c:forEach>
            
                <c:if test="${requestScope.students ne null}">
                 <tr>
                     <c:forEach items="${requestScope.exams}" var="e">
                    <td>
                        <input type="hidden" name="gradeid" value="${students.id}_${e.id}" />
                        <c:set var="found" value="false" />
                        <c:forEach items="${requestScope.grades}" var="g">
                            <c:if test="${g.exam.id eq e.id and g.student.id eq students.id}">
                                <label>${g.score}</label>
                                <c:set var="found" value="true" />
                            </c:if>
                        </c:forEach>
                        <c:if test="${not found}">
                            <label style="color: red">null</label>
                        </c:if>
                    </td>
                </c:forEach>
                </tr>   
                </c:if>
           

        </table>
    </body>
</html>
