<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Spitter</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
</head>
<body>
	<h1>
		<c:out value="${spitter.firstName}" />
		's Profile
	</h1>
	Username: <c:out value="${spitter.username}" />
	<br />
	First Name: <c:out value="${spitter.firstName}" /> 
	<br />
	Last Name: <c:out value="${spitter.lastName}" />
	<br />
	Email: <c:out value="${spitter.email}" />
</body>
</html>