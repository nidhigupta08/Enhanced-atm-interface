<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Transfer Funds</title>
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
        <h2>Transfer Funds</h2>
        <form action="${pageContext.request.contextPath}/TransferServlet" method="post">
            <label for="recipientId">Recipient User ID:</label>
            <input type="text" id="recipientId" name="recipientId" required>
            <label for="amount">Amount:</label>
            <input type="number" id="amount" name="amount" required>
            <button type="submit">Transfer</button>
        </form>
        <a href="${pageContext.request.contextPath}/mainMenu">Back to Main Menu</a>
    </div>
</body>
</html>
