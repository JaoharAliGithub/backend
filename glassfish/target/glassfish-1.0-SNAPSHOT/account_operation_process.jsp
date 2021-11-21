<%@ page import="com.example.glassfish.ejb.*" %><%--

  Created by IntelliJ IDEA.
  User: jaoha
  Date: 2021-10-21
  Time: 5:58 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    Account remoteAccount = (Account) session.getAttribute("remote_account");
    String operation = request.getParameter("operation");
    String amount = request.getParameter("amount");

    if (operation != null) {

        if (operation.equals("deposit")) {
            remoteAccount.deposit(Integer.parseInt(amount));
            out.print("Amount ($" + amount + ") successfully deposited!");
            out.println("Current Balance: " + remoteAccount.getBalance());
        } else if (operation.equals("withdraw")) {
            remoteAccount.withdraw(Integer.parseInt(amount));
            out.print("Amount ($" + amount + ") successfully withdrawn!");
            out.println("Current Balance: " + remoteAccount.getBalance());
        } else {
            out.println("Current Balance: " + remoteAccount.getBalance());
        }
    }
%>

<hr/>
<br/>
<a href="account_operation.jsp">Go to Account Operation Page</a>

</body>
</html>