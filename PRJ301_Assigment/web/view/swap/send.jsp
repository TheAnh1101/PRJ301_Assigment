<%-- 
    Document   : send
    Created on : Jul 17, 2024, 1:23:21 AM
    Author     : AD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Send Request Page</title>
        <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form {
            max-width: 400px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin-bottom: 10px;
            color: #333;
        }
        input[type="text"],
        input[type="email"],
        input[type="number"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .submitted-data {
            max-width: 400px;
            margin: 20px auto;
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .submitted-data p {
            margin-bottom: 10px;
        }
    </style>
    </head>
    <body>
        <h1>Create a request to transfer courses</h1>
    <form method="post" action="request">
        <label for="sender">Name Sender:</label>
        <input type="text" name="sender" id="sender" value="${sessionScope.user.student.name}" required><br>
        <input type="hidden" name="sender_id" value="${sessionScope.user.student.id}">
        
        <label for="fromclass">From Class:</label>
        <select name="fromclass">
                <c:forEach items="${requestScope.listCouCurrent}" var="c">
                    <option value="${c.id}">${c.name}</option>
                </c:forEach>
            </select>
        
        <label for="receiver">Name Receiver:</label>
        <input type="text" name="receiver" id="receiver" value="${requestScope.targetStu.name}" required><br>
        <input type="hidden" name="receiver_id" value="${requestScope.targetStu.id}">
        
        <label for="toclass">To Class:</label>
        <select name="toclass">
                <c:forEach items="${requestScope.listCouTarget}" var="t">
                    <option value="${t.id}">${t.name}</option>
                </c:forEach>
            </select>
        
        <label for="mess">Messeger:</label>
        <input type="text" placeholder="something..." name="mess" id="mess" required><br>
        <br>
        <input type="submit" value="Create">
    </form>
    </body>
</html>
