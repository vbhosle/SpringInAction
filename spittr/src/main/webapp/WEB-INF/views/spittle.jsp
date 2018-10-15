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
	<c:choose>
		<c:when test="${not empty spittle}">
			<div class="spittleView">
				<div class="spittleMessage">
					<c:out value="${spittle.message}" />
				</div>
				<div>
					<span class="spittleTime"><c:out value="${spittle.time}" /></span>
				</div>
			</div>
		</c:when>
		<c:otherwise>
        	Not found
        <br />
		</c:otherwise>
	</c:choose>
</body>
</html>