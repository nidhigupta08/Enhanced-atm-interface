<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 
 <!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ATM Interface</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/style.css">
</head>
<body>
    <header>
        <div class="container">
            <div id="branding">
                <h1>Welcome to the ATM Interface</h1>
                 <img src="${pageContext.request.contextPath}/images/atm.jpg" alt="ATM Logo" class="logo">
            </div>
        </div>
    </header>
    <div class="container">
        <h2>Please login to access your account</h2>
        <a href="LoginServlet" class="btn-primary">Login</a>
    </div>
</body>
</html>
 