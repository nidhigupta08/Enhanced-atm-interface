<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/style.css" />
</head>
<body>
   
    <div class="container">
        <h2>Login</h2>
        <form action="LoginServlet" method="post" class="form">
           
            <div class="form-group">
                 <label for="userId">User ID:</label>
            <input type="text" id="userId" name="userId" required>
            </div>
            <div class="form-group">
               <label for="pin">PIN:</label>
            <input type="password" id="pin" name="pin" required>
            </div>
            <input type="submit" id="button" class="btn-primary" value="Login" />
            <c:if test="${not empty error}">
                <p style="color:red;">${error}</p>
            </c:if>
        </form>
    </div>
</body>
</html>
