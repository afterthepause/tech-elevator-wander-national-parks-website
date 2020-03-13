<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:import url="/WEB-INF/jsp/common/header.jsp">
<c:param name="Wander: Your National Parks Resource" value="favoriteParks" />
</c:import>

<c:url var="imgUrl" value="/img/parks/${park.parkCode.toLowerCase()}.jpg" />
<ol>
<c:forEach items="${surveyCount}" var="survey">

	<c:url var="imgUrl" value="/img/parks/${survey.key.parkCode.toLowerCase()}.jpg" />

	<li><img src="${imgUrl}"/><c:out value="${survey.key.parkName}: ${survey.value}"/></li>

</c:forEach>
</ol>