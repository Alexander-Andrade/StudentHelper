<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	import="edu.bsuir.sh.beans.UserBean"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>ChoseTable</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR"
	content="Rational® Application Developer for WebSphere® Software">
</head>
<body>
<form action="ChoseTableServ" method="post">
	<input name="table" type="submit" value="marks">
	<c:if test="${user.role == 'admin'}">
		<input name="table" type="submit" value="groups">
		<input name="table" type="submit" value="students">
		<input name="table" type="submit" value="professors">
		<input name="table" type="submit" value="studies">
	</c:if>
	
</form>


</body>
</html>