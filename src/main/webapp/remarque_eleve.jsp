<%--
  Created by IntelliJ IDEA.
  User: HWoog
  Date: 21/06/2016
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/remarque_eleve" method="post">
    <textarea name="remarque" cols="30" rows="10" placeholder="Modifier la remarque de l'élève"></textarea>
    <input type="hidden" name="id_eleve" value="${ ficheeleve.id }" />
    <button type="submit" class="btn btn-primary">Modifier remarque</button>
</form>

</body>
</html>
