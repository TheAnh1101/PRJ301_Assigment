<%-- 
    Document   : list
    Created on : Jul 17, 2024, 3:48:01 AM
    Author     : AD
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Request</title>
        <style>
            /* CSS for ViewScoreStudent page */
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f5f5f5; /* optional background color */
            }

            table {
                border-collapse: collapse;
                width: 100%;
            }

            table, th, td {
                border: 1px solid ;
            }

            th, td {
                padding: 8px;
                text-align: left;
            }

            tr:nth-child(even) {
                background-color: #f2f2f2;
            }

            tr:hover {
                background-color: #ddd;
            }

            .font-red {
                color: red;
            }

            .font-green {
                color: green;
            }

            .font-orange {
                color: orange;
            }

            input[type=button] {
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
            input[type=button]:hover {
                background-color: #ff7f00;
            }
            
            input[type=submit] {
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
            input[type=submit]:hover {
                background-color: #ff7f00;
            }
        </style>
    </head>
    <body>
        <a href="/FAP_FPT_ASM/home/indexHomeStudent.html"><input type="button" value="Home"/></a>
            <%int i = 1;%>
        <br/>
        
        <c:if test="${not empty sessionScope.user}">
            <table border="1px">
                <tr>
                    <td>NO</td>
                    <td>REQUEST CODE</td>
                    <td>SENDER</td>
                    <td>FROM COURSE</td>
                    <td>RECEIVER</td>
                    <td>TO COURSE</td>
                </tr>
               
                    <tr>
                        <td><%= i %>
                            <% i++; %></td>
                        <td>
                                1
                        </td>
                        <td>Ha The Anh</td>
                        <td>SE1830-IOT302</td>
                        <td>Nguyen Van A</td>
                        <td>SE1871-PRJ301</td>
                        <td>
                        </td>
                    </tr>
               
            </table>
        </c:if>

    </body>
</html>
