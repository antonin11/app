<%@ page import="com.g4.app.models.FicheEleve" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Acceuil Tuteur</title>
        <link rel="stylesheet" href="static/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="static/bootstrap/css/bootstrap-theme.css">
        <link href="static/css/all.css" rel="stylesheet">

        <title>Fiche d'un élève</title>
    </head>
    <body>



        <p><c:out value="${ eleve.prenom }" /></p>
        <p><c:out value="${ eleve.nom }" /></p>
        <p><c:out value="${ eleve.mail }" /></p>
        <p><c:out value="${ eleve.type }" /></p>
        <p><c:out value="${ eleve.remarque }" /></p>

        <form action="/remarque_eleve" method="post">
            <input type="hidden" name="id_eleve" value="${ ficheeleve.id }" />
            <button type="submit" class="btn btn-primary">Modifier la remarque de l"élève</button>
        </form>


    </body>
</html>
