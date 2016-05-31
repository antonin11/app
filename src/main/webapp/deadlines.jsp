<%@ page import="com.g4.app.models.Deadlines" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: antoninpedotti
  Date: 25/05/2016
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deadlines list</title>
</head>
<body>
<%
    List<Deadlines> deadlinesList = (ArrayList<Deadlines>)request.getAttribute("deadlinesList");
    for (Deadlines deadlines : deadlinesList) {

        SimpleDateFormat formater = null;
        formater = new SimpleDateFormat("'le' dd MMMM yyyy 'à' hh:mm:ss");

        out.println(deadlines.name);
        out.println(formater.format(deadlines.milestone));
    }

%>

</body>
</html>
