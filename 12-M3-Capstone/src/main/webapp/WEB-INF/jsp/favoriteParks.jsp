<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="Wander: Your National Parks Resource"
		value="favoriteParks" />
</c:import>


<body class="parkListing">
<div class="surveyOut">
<c:url var="imgUrl" value="/img/parks/${park.parkCode.toLowerCase()}.jpg" />
	<c:forEach items="${surveyCount}" var="survey">
	<c:if test="${survey.value > 1 }">
	<br>
	<h2><c:out value="${survey.key.parkName}" /></h2>
		<c:url var="imgUrl" value="/img/parks/${survey.key.parkCode.toLowerCase()}.jpg" />
		<img class="surveyImg" src="${imgUrl}" />
		<h3>Vote Count: ${survey.value}</h3></li>
		<br>
		<hr class="survey">
		</c:if>
	</c:forEach>
	</div>
