<%--
  Created by IntelliJ IDEA.
  User: promoscow
  Date: 26.07.17
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Notes</title>
</head>
<body>
<section>
    <h3>Notes info</h3>
    <jsp:useBean id="note" scope="request" type="Note"/>
    <tr>
        <td>Name: ${note.name} | Text: ${note.text}</td>
        <td><a href="notes?action=update">Update</a></td>
    </tr>
</section>
</body>
</html>