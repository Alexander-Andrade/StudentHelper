<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	import="edu.bsuir.sh.beans.UserBean"
	import="edu.bsuir.sh.beans.GroupBean"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR"
	content="Rational® Application Developer for WebSphere® Software">
</head>
<body>
	<table border="1">
		<tr>
			<th>group number</th>
			<th>average mark</th>
			<c:if test="${user.role == 'admin'}">
					<th>Edit Group</th>
					<th>Add Group</th>
					<th>Delete Group</th>
			</c:if>
		</tr>
		<c:forEach items="${groups}" var="group">
			<tr>
				<td>${group.groupNumber}</td>
				<td>${group.avgMark}</td>
				<c:if test="${user.role == 'admin'}">
					<td><a href="GroupEdit.jsp?oper=Edit&group_number=${group.groupNumber}&avg_mark=${group.avgMark}">Edit</a></td>
					<td><a href="GroupEdit.jsp?oper=Add&group_number=${group.groupNumber}&avg_mark=${group.avgMark}">Add</a></td>
					<td><a href="GroupEdit.jsp?oper=Delete&group_number=${group.groupNumber}&avg_mark=${group.avgMark}">Delete</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
</body>
</html>