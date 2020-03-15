<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<c:import url="/WEB-INF/jsp/common/header.jsp" />
<body class="parkListing">
<h1 class="pagedetailh1" style="text-align:center">Vote for Your Favorite National Park</h1>
	<div id="surveyPage">
		<div class="title">
			
			<br>
		</div>
		<div class="surveyWrapper">
			<div class="surveyOne">
				<span class="surveyText"> <c:url var="surveyURL"
						value="/survey" /> <form:form action="${surveyURL}" method="POST"
						modelAttribute="newSurvey">

						<label for="parkCode">Your Favorite Park</label>
						<br />
						<form:select path="parkCode">
							<c:forEach items="${parks}" var="park">

								<form:option value="${park.parkCode}">
									<c:out value="${park.parkName}" />
								</form:option>

							</c:forEach>
						</form:select>
						<br />
						<br />
						<label for="email">Your Email Address</label>
						<br />
						<form:input path="email" placeholder="email address" />
						<br />
						<form:errors path="email" cssClass="errors" />
						<br />
						<label for="state">Your State of Residence</label>
						<br />
						<form:input path="state" placeholder="state" />
						<br />
						<form:errors path="state" cssClass="errors" />
						<br /></span>
			</div>

			<div class="surveyTwo">
				<span class="surveyText"> <label for="activityLevel">Your
						Activity Level</label> <br /> </span>
						<span class="surveyTextChoice"> 
						<form:radiobutton value="inactive" path="activityLevel" />
						&nbsp;&nbsp;I Only Watch NatGeo Shows About Parks <br> 
						<form:radiobutton value="sedentary" path="activityLevel" />
						&nbsp;&nbsp;I Just Walk the Paths... Sometimes<br>
						<form:radiobutton value="active" path="activityLevel" />
						&nbsp;&nbsp;Trail Rippin' Guru <br>
						<form:radiobutton value="extremely active" path="activityLevel" />
						&nbsp;&nbsp;The Ground Fears My Hiking Boot<br> 
						<form:errors path="activityLevel" cssClass="errors" /> <br /></span>
			</div>
			<div class="submitButton">
				<input type="submit" value="Let it rip, dude!" /></span>
				</form:form>
			</div>
		</div>
	</div>
</body>

