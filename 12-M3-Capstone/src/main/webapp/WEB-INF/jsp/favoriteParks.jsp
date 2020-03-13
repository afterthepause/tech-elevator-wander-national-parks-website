<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:import url="/WEB-INF/jsp/common/header.jsp">
<c:param name="Wander: Your National Parks Resource" value="favoriteParks" />
</c:import>



<c:forEach items="${surveyCount}" var="survey">

	<c:out value="${survey}"/>

</c:forEach>
