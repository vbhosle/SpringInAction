<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<title>Spitter</title>
</head>
<body>
	<div class="listTitle">
		<h1>Recent Spittles</h1>
		<ul class="spittleList">
			<c:forEach items="${spittleList}" var="spittle">
				<li id="spittle_<c:out value="spittle.id"/>">
					<div class="spittleCard">
						<div class="spittleMessage">
							<c:out value="${spittle.message}" />
						</div>
						<div>
							<span class="spittleAuthor"><c:out
									value="- ${spittle.spitter.firstName} ${spittle.spitter.lastName}" /></span>
							<span class="spittleTime"><c:out
									value=" (${spittle.postedTime})" /></span>
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>