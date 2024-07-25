<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Deposit Money</title>
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
        <h2>Deposit Money</h2>
        <form action="${pageContext.request.contextPath}/DepositServlet" method="post">
            <label for="amount">Amount:</label>
            <input type="number" id="amount" name="amount" required>
            <button type="submit">Deposit</button>
        </form>
        <a href="${pageContext.request.contextPath}/mainMenu">Back to Main Menu</a>
    </div>
</body>
</html>
