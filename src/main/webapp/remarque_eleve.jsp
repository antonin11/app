<%@ page import="com.g4.app.models.FicheEleve" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Modifier la remarque de <c:out value="${ eleve.prenom }" /></h1>

<form action="/ajout_remarque" method="post">
    <textarea name="remarque" cols="30" rows="10" placeholder="Modifier la remarque de l'élève">${ eleve.remarque }</textarea>
    <input type="hidden" name="id_eleve" value="${ eleve.id }" />
    <button type="submit" class="btn btn-primary">Modifier remarque</button>
</form>

</body>
</html>
