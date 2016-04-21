<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	import="edu.bsuir.sh.beans.Group"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>drawGroupView</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR"
	content="Rational® Application Developer for WebSphere® Software">
</head>
<body>
	<table border="1">
		<tr>
			<th>group number</th>
			<th>average mark</th>
		</tr>
		<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.groupNumber}"></td>
				<td><c:out value="${item.avgMark}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>