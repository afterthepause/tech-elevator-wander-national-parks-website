<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<c:import url="/WEB-INF/jsp/common/header.jsp"/>


<c:url var="surveyURL" value="/survey"/>

<form:form action="${surveyURL}" method="POST" modelAttribute="newSurvey">

<label for="parkCode">Choose a Park:</label>
	<br/>
<form:select path="parkCode">
	<c:forEach items="${parks}" var="park">
	
		<form:option value="${park.parkCode}"><c:out value="${park.parkName}"/></form:option>
		
	</c:forEach>
</form:select>
		<br/>
		<br/>
	<label for="email">Input your email address:</label>
		<br/>
	<form:input path="email"/>
		<br/>
	<form:errors path="email" cssClass="errors"/>
		<br/>
	<label for="state">Input your state of residence:</label>
		<br/>
	<form:input path="state"/>
		<br/>
	<form:errors path="state" cssClass="errors"/>
		<br/>
	<label for="activityLevel">Select how active you are in your life:</label>
		<br/>
	<form:radiobutton value="inactive"  path="activityLevel"/>Inactive
		<br/>
	<form:radiobutton value="sedentary"  path="activityLevel"/>Sedentary
		<br/>
	<form:radiobutton value="active"  path="activityLevel"/>Active
		<br/>
	<form:radiobutton value="extremely active"  path="activityLevel"/>Extremely Active
		<br/>
	<form:errors path="activityLevel" cssClass="errors"/>
		<br/>
	<input type="submit" value="Let it rip, dude!"/>




</form:form>