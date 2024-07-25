<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Withdraw Money</title>
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
        <h2>Withdraw Money</h2>
        <form action="${pageContext.request.contextPath}/WithdrawServlet" method="post">
            <label for="amount">Amount:</label>
            <input type="number" id="amount" name="amount" required>
            <button type="submit">Withdraw</button>
        </form>
        <c:if test="${not empty message}">
            <div class="message">${message}</div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <a href="${pageContext.request.contextPath}/mainMenu">Back to Main Menu</a>
    </div>
</body>
</html>
 
  