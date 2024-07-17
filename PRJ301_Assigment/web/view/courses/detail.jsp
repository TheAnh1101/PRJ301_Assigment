<%-- 
    Document   : detail
    Created on : Jul 16, 2024, 11:09:42 PM
    Author     : AD
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Detail Courses</title>
 <style>
            /* CSS for ViewScoreStudent page */
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f5f5f5; /* optional background color */
            }

            .table-course {
                border-collapse: collapse;
                width: 100%;
                margin: 20px 0;
                border: 2px solid #4CAF50;
            }

            .table-course th, .table-course td {
                border: 2px solid #4CAF50;
                padding: 12px;
                text-align: left;
            }

            .table-course th {
                background-color: #4CAF50; /* Green background for header */
                color: white; /* White text for header */
            }

            .table-course tr:nth-child(even) {
                background-color: #f2f2f2;
            }

            .table-course tr:hover {
                background-color: #ddd;
            }

            .table-student {
                border-collapse: collapse;
                width: 100%;
                margin: 20px 0;
                border: 2px solid #2196F3;
            }

            .table-student th, .table-student td {
                border: 2px solid #2196F3;
                padding: 12px;
                text-align: left;
            }

            .table-student th {
                background-color: #2196F3; /* Blue background for header */
                color: white; /* White text for header */
            }

            .table-student tr:nth-child(even) {
                background-color: #e3f2fd;
            }

            .table-student tr:hover {
                background-color: #bbdefb;
            }

            input[type=button], input[type=submit] {
                background-color: orange;
                border: none;
                color: white;
                padding: 10px 20px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                cursor: pointer;
                border-radius: 4px;
            }

            input[type=button]:hover, input[type=submit]:hover {
                background-color: #ff7f00;
            }
        </style>
         <script>
            function goToStudentDetail(studentId) {
                window.location.href = 'request?sid=' + studentId;
            }
        </script>
    </head>
    <body>
        <a href="list"><input type="button" value="List Course"/></a>
            <%int i = 1;%>
        <br/>

        <c:if test="${not empty requestScope.course}">
            <table class="table-course" border="1px">
                <tr>
                    <th><strong>COURSE ID</strong></th>
                    <th><strong>COURSE NAME</strong></th>
                    <th><strong>SUBJECT</strong></th>
                    <th><strong>LECTURER</strong></th>
                    <th><strong>SEASON</strong></th>
                    <th><strong>YEAR</strong></th>
                </tr>
                <tr>
                    <td>
                        ${course.id}
                    </td>
                    <td>${course.name}</td>
                    <td>${course.subject.name}</td>
                    <td>${course.lecturer.name}</td>
                    <td>${course.semester.season}</td>
                    <td>${course.semester.year}</td>
                </tr>
            </table>
                <br>
                <br>
                <br>
                <br>
            <table class="table-student" border="1px">
                <tr>
                    <th>NO</th>
                    <th>STUDENT CODE</th>
                    <th>STUDENT NAME</th>
                    <th>SEX</th>
                    <th>ACTION</th>

                </tr>
                <c:forEach items="${requestScope.students}" var="s">
                    <tr>
                        <td><%= i %>
                            <% i++; %></td>
                        <td>
                            ${s.id}
                        </td>
                        <td>${s.name}</td>
                        <td>${s.gender?"Male":"Female"}</td>
                        <td><a href="${pageContext.request.contextPath}/course/request?sid=${s.id}&cid=${course.id}">Swap Course</a></td>

                    </tr>
                </c:forEach>
            </table>
        </c:if>

    </body>
</html>
