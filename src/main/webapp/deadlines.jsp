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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Deadline List</title>
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap-theme.css">
    <link href="static/css/all.css" rel="stylesheet">
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
<container>
    <div class="row">
        <div class="col-sm-6">
            <form action="/deadlines" method="post">
                <input type="text" name="nom" placeholder="nom">
                <input type="text" name="description" placeholder="description">
                <div class='input-group date' id='datetimepicker1'>
                    <input type='text' class="form-control" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</container>


<script type="text/javascript">
    $(function () {
        $('#datetimepicker1').datetimepicker();
    });
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="static/bootstrap/js/bootstrap.js"></script>
</body>
</html>
