<%@ page import="com.g4.app.models.FicheEleve" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
<container>
    <div class="row">
        <div class="col-md-4">
            <c:forEach items="${ ficheEleveList }" var="ficheeleve">
                <p><c:out value="${ ficheeleve.prenom }" /></p>

                <form action="/fiche_eleve" method="post">
                    <input type="hidden" name="id_eleve" value="${ ficheeleve.id }" />
                    <button type="submit" class="btn btn-primary">Aller sur la fiche de l'eleve</button>
                </form>
            </c:forEach>
        </div>
        <div><a href="/deadlines">Aller a la page deadlines</a></div>
    </div>
    
</container>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="static/bootstrap/js/bootstrap.js"></script>
</body>
</html>
