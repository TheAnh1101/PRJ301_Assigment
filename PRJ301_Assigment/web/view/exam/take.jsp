<%-- 
    Document   : take
    Created on : Jun 24, 2024, 8:26:46 AM
    Author     : sonnt-local
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
        <form action="take" method="POST">
            <table border="1px">
                <tr>
                    <th></th>
                    <c:forEach items="${requestScope.exams}" var="e">
                        <th>
                            <span style="color:red;">${e.assessment.name}</span>|
                            ${e.date} - ${e.assessment.weight}%
                        </th>
                    </c:forEach>
                </tr>
                <c:forEach items="${requestScope.students}" var="s">
                 <tr>
                    <td>${s.name}</td>
                    <c:forEach items="${requestScope.exams}" var="e">
                        <td>
                            <input type="hidden" name="gradeid" value="${s.id}_${e.id}" />
                            <input type="number" name="grade${s.id}_${e.id}" min="0" max="10" 
                                   
                                   <c:forEach items="${requestScope.grades}" var="g">
                                       <c:if test="${g.exam.id eq e.id and g.student.id eq s.id}">
                                       value="${g.score}"
                                       </c:if>
                                   </c:forEach>
                                   />
                        </td>
                    </c:forEach>
                </tr>   
                </c:forEach>
            </table>
            <input type="hidden" name="cid" value="${param.cid}"/>
            <input type="submit" value="save" />
        </form>
    </body>
</html>
