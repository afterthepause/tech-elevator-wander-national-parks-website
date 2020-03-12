<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/jsp/common/header.jsp">
<c:param name="Wander: Your National Parks Resource" value="homepage" />
</c:import>

<body class="parklisting">
<div class="parkdetail">
<div class="headingdetail">
<h1 class="pagedetailh1"><c:out value="${park.parkName}" /></h1>
</div>

<div class="quote">
<p class="quote">"<c:out value="${park.inspirationalQuote}" />"
- <c:out value="${park.inspirationalQuoteSource}" />
</p>
</div>


<div class="detailimg">
<c:url var="imgUrl" value="/img/parks/${park.parkCode.toLowerCase()}.jpg" />
<img class="pagedetailimg" src="${imgUrl}"/>
</div>

<div class="detaildesc">
<p class="pagedetaildescription">
<c:out value="${park.parkDescription}" />
</p>
</div>




<div class="factstable">
<h1>Fun Park Facts</h1>

<p class="field1">Location:</p> <p class="field2"><c:out value="${park.state}" /></p>
<br>
<p class="field1">Park Size:</p> <p class="field2"><c:out value="${park.acreage}" /> acres</p>
<br>
<p class="field1">Elevation:</p> <p class="field2"><c:out value="${park.elevationInFeet}" /> feet</p>
<br>
<p class="field1">Miles of Trail:</p> <p class="field2"><c:out value="${park.milesOfTrail}" /> miles</p>
<br>
<p class="field1">Number of Campsites:</p> <p class="field2"><c:out value="${park.numberOfCampsites}" /> </p>
<br>
<p class="field1">Climate: </p> <p class="field2"><c:out value="${park.climate}" /></p>
<br>
<p class="field1">Year Founded: </p> <p class="field2"><c:out value="${park.yearFounded}" /></p>
<br>
<p class="field1">Annual Visitor Count: </p> <p class="field2"><c:out value="${park.annualVisitorCount}" /></p>
<br>
<p class="field1">Animal Species: </p> <p class="field2"><c:out value="${park.numberOfAnimalSpecies}" /></p>
<br>
</div>

<div id="weatherHead">5 Day Weather Forecast</div>
			<c:url var="formActionUrl" value="/parkDetail" />
			<div class="row justify-content-center"><div class="col- weather"><strong>Select Preferred Temperature Unit:</strong><br><form
					action="${formActionUrl}?parkCode=${park.parkCode}" method="post">
					<label for="tempUnit"><input name="tempUnit" type="radio"
						value="F">Fahrenheit</label> <label for="tempUnit"><input
						name="tempUnit" type="radio" value="C">Celcius</label> <input
						type="submit" class="btn btn-primary">
				</form></div></div>
<div class="weather">
<c:forEach var="weatherList" items="${weatherList }">

<c:out value="${weatherList.fiveDayForecastValue}" />
<c:url var="imgUrl" value="/img/weather/${weatherList.forecast}.png" />
<img class="weatherimg" src="${imgUrl}" />
<c:out value="${weatherList.lowFar }" />
<c:out value="${weatherList.highFar}" />
</c:forEach>

<div class="row justify-content-center">
			<div class="col- weather ">
				Today
				<div id="todayImg">
					<c:if test="${tempUnit == 'F'}">
						<c:set var="low" value="${weatherList[0].lowFar}" />
						<c:set var="high" value="${weatherList[0].highFar}" />
					</c:if>
					<c:if test="${tempUnit == 'C'}">
						<c:set var="low" value="${weatherList[0].lowCel}" />
						<c:set var="high" value="${weatherList[0].highCel}" />
					</c:if>
					<c:url var="todayWeatherUrl" value="/img/weather/${weatherList[0].forecast}.png" />
					<img src="${todayWeatherUrl}" alt="${weatherList[0].forecast}" /><br>
					<c:out value="${weatherList[0].forecastMessage}"/><br>
					Low:
					<c:out value="${low}" />&#xb0 <c:out value="${tempUnit}"/>
					<br> High:
					<c:out value="${high}" />&#xb0 <c:out value="${tempUnit}"/>
					<br>
					<c:out value="${weatherList[0].tempMessage}" />
				</div>
			</div>
		</div>
		<div class="row">
			<c:forEach begin="1" end="4" items="${weatherList}" var="weather">
				<c:if test="${tempUnit == 'f'}">
					<c:set var="low" value="${weatherList.lowFar}" />
					<c:set var="high" value="${weatherList.highFar}" />
				</c:if>
				<c:if test="${tempUnit == 'c'}">
					<c:set var="low" value="${weatherList.lowCel}" />
					<c:set var="high" value="${weatherList.highCel}" />
				</c:if>
				<div class="col-sm weather">
					Day
					<c:out value="${weatherList.fiveDayForecastValue}" />
					<div class="weatherContent">
						<c:url var="imgUrl"
							value="/img/weather/${weatherList.forecast}.png" />
						<img src="${imgUrl}" alt="${weather.forecast}" /><br> 
						<c:out value="${weather.forecastMessage}"/><br>
						Low:
						<c:out value="${low}" />&#xb0 <c:out value="${tempUnit}"/>
						<br> High:
						<c:out value="${high}" />&#xb0 <c:out value="${tempUnit}"/>
						<br>
						<c:out value="${weather.tempMessage}" />
					</div>
				</div>
			</c:forEach>




</div>
</div>
</body>
</body>
