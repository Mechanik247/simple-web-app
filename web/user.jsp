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
			<h3>Users info</h3>
			<tr>
				<td>ID: ${id} | Name: ${name} | Password: ${pass} | EMail: ${eMail}</td>
			</tr>
		</section>
	</body>
</html>