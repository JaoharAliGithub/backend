<%--
  Created by IntelliJ IDEA.
  User: jaoha
  Date: 2021-10-21
  Time: 5:23 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="account_operation_process.jsp">
  Enter Amount:<input type="text" name="amount"/><br>

  Choose Operation:
  Deposit<input type="radio" name="operation" value="deposit"/>
  Withdraw<input type="radio" name="operation" value="withdraw"/>
  Check Balance<input type="radio" name="operation" value="checkbalance"/>\
  <br>
  <input type="submit" value="submit">
</form>
</body>
</html>
