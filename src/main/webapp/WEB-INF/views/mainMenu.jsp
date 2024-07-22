<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Main Menu</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/style.css">
    <script src="${pageContext.request.contextPath}/scripts.js"></script>
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
        <h2>Main Menu</h2>
        <ul>
            <li><a href="TransactionHistoryServlet">View Transaction History</a></li>
            <li><a href="WithdrawServlet">Withdraw Money</a></li>
            <li><a href="DepositServlet">Deposit Money</a></li>
            <li><a href="TransferServlet">Transfer Funds</a></li>
            <li><a href="LogoutServlet">Logout</a></li>
        </ul>
    </div>
</body>
</html>
