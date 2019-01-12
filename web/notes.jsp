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
	<jsp:useBean id="notes" type="java.util.Collection" scope="request" />
    <h3>Notes info</h3>
		<c:forEach items="${notes}" var="note">
			<tr>      
				<td>Note: </td>
				<td>ID: ${note.id} | </td>
				<td>Title: ${note.title} |</td>
				<td>Text: ${note.text}</td>
			</tr><br>
		</c:forEach>
    </tr>
</section>
</body>
</html>