<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Logout</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/style.css">
</head>
<body>
    <header>
        <div class="container">
            <div id="branding">
                <h1>ATM Interface</h1>
            </div>
        </div>
    </header>
    <div class="container">
        <h2>You have successfully logged out.</h2>
        <a href="${pageContext.request.contextPath}/index.jsp">Login Again</a>
    </div>
</body>
</html>
