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
			<h3>Notes info</h3>
			<tr>
				<td>ID: ${id} | Title: ${title} | Text: ${text} | Creation_date: ${cDate} | Author_ID: ${author_id}</td>
			</tr>
		</section>
	</body>
</html>