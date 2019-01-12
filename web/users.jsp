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
    <title>Users</title>
</head>
<body>
<section>
	<jsp:useBean id="users" type="java.util.Collection" scope="request" />
    <h3>Users info</h3>
		<c:forEach items="${users}" var="user">
			<tr>      
				<td>User: </td>
				<td>ID: ${user.id} | </td>
				<td>Name: ${user.name} | </td>
				<td>Password: ${user.encrypted_password} | </td>
				<td>EMail: ${user.EMail}</td>
			</tr><br>
		</c:forEach>
    </tr>
</section>
</body>
</html>