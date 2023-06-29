<%--
  Created by IntelliJ IDEA.
  User: tiennh
  Date: 6/29/23
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Hello ${ name1 }</h2>
    <form method="GET"
          action="/SU23B2_SOF3011_SD18105_war_exploded/hello">
        <input type="text" name="ten" />
        <button>Submit</button>
    </form>
</body>
</html>
