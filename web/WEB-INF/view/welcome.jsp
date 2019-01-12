<%--
  Created by IntelliJ IDEA.
  User: promoscow
  Date: 26.07.17
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Notes</title>
</head>
<body>
<section>
	<jsp:useBean id="listNotes" type="java.util.ArrayList" scope="session" />
    <h3>Notes info</h3>
    <tr>
        <td>Name: ${noteName} | Text: ${noteText}</td>
		<c:forEach items="${listNotes}" var="note">
    <tr>      
        <td>${note.title}</td>
        <td>${note.text}</td>
    </tr>
</c:forEach>
        <td><a href="notes?action=update">Update</a></td>
    </tr>
</section>
</body>
</html>