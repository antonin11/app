<%@ page import="com.g4.app.models.FicheEleve" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%--
  Created by IntelliJ IDEA.
  User: HWoog
  Date: 17/06/2016
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Acceuil Tuteur</title>
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap-theme.css">
    <link href="static/css/all.css" rel="stylesheet">
</head>
<body>
<%
    List<FicheEleve> ficheeleveList = (ArrayList<FicheEleve>)request.getAttribute("fichEleveList");
    for (FicheEleve ficheeleve : ficheeleveList) {
%>
//faire tableau


        out.println(ficheeleve.nom);
        out.println(ficheeleve.prenom);
        out.println(ficheeleve.mail);
<%
    }

%>
<container>
    <div class="row">
        <div class="col-sm-6">
            <a href="/"></a>
        </div>
    </div>
</container>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="static/bootstrap/js/bootstrap.js"></script>
</body>
</html>
