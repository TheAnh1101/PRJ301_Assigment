<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Reset Password</title>
        <link href="${pageContext.request.contextPath}/css/resetpass.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h2>Reset Password</h2>
            <form action="change" method="post">
                <div class="form-group">
                    <label for="code">Verification Code:</label>
                    <input type="text" id="code" name="code" required>
                </div>
                <div class="form-group">
                    <label for="newPassword">New Password:</label>
                    <input type="password" id="newPassword" name="newPassword" required>
                </div>
                <div class="form-group">
                    <label for="confirmPassword">Confirm New Password:</label>
                    <input type="password" id="confirmPassword" name="confirmPassword" required>
                </div>
                <button type="submit">Submit</button>
            </form>
            <br>
            <% 
                String message = (String) request.getAttribute("message");
                if (message != null) {
            %>
            <div class="message">
                <%= message %>
            </div>
            <% 
                }
            %>
        </div>
    </body>
</html>
