<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<c:import url="/WEB-INF/jsp/common/header.jsp"/>


<c:url var="surveyURL" value="/survey"/>

<form:form action="${surveyURL}" method="POST" modelAttribute="newSurvey">

<label for="parkCode">Choose a Park:</label>
<form:select path="parkCode">
	<c:forEach items="${parks}" var="park">
	
		<form:option value="${park.parkCode}"><c:out value="${park.parkName}"/></form:option>
	
	</c:forEach>
</form:select>

	<label for="email">Input your email address:</label>
	<form:input path="email"/>
	<form:errors path="email" cssClass="errors"/>
		<br/>
	<label for="state">Input your state of residence:</label>
	<form:input path="state"/>
	<form:errors path="state" cssClass="errors"/>
		<br/>
	<label for="activityLevel">Input how active you are in your life:</label>
	<form:input path="activityLevel"/>
	<form:errors path="activityLevel" cssClass="errors"/>
		<br/>
	<input type="submit" value="Let it rip, dude!"/>




</form:form>