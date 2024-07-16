<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Forgot Password</title>
        <link href="../../css/forgotpass.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h2>Forgot Password</h2>
            <form action="verify" method="post">
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <button type="submit">Send Mail</button>
                <div></div>
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
