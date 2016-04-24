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
	<!-- Make not editable fields inactive -->
	<form action="GroupEditServ" method= "post">
		<input name="group_number" type="text" value="${param.group_number}" 
		<c:if test="${ param.oper == 'Delete'}"> disabled</c:if>>
		
		<input name="avg_mark" type="text" value="${param.avg_mark}" 
		<c:if test="${param.oper == 'Delete'}"> disabled </c:if>>
		
		<input name="oper" type="submit" value="${param.oper}">		
	</form>
</body>
</html>