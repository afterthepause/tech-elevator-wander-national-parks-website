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


<c:url var = "parkDetailURL" value = "/parkDetail">
<c:param name = "currentParkCode" value = "${park.parkCode}"/>
</c:url>

<div class="weatherSelector">
	5 Day Weather Forecast:<br>
	View Weather in:
	<br>
	<c:url var="tempButton" value="${parkDetailURL}" />
	<form action="${parkDetailURL}?parkCode=${park.parkCode}"  >
	<label for="tempUnit"><input name="tempUnit" type="radio" value="F">Fahrenheit</label> 
	<label for="tempUnit"><input name="tempUnit" type="radio" value="C">Celcius</label> 
	<input type="submit" class="btn btn-primary">
	</form>
</div>

<div class="weatherContainer">

	<div class="todaysWeather">
	<c:out value="${weatherList[0].fiveDayForecastValue}" />
	<c:url var="imgUrl" value="/img/weather/${weatherList[0].forecast}.png" />
	<img class="weatherImg" src="${imgUrl}" />
	<c:out value="${weatherList[0].forecastMessage}" />
	H: <c:out value="${weatherList[0].highFar }" /> / L: <c:out value="${weatherList[0].lowFar}" />
	<c:out value="${weatherList[0].tempMessage}" />
	</div>

	<div class="extendedWeather">
	<c:forEach begin="1" end="4" var="weatherList" items="${weatherList }">
	<c:out value="${weatherList.fiveDayForecastValue}" />
	<c:url var="imgUrl" value="/img/weather/${weatherList.forecast}.png" />
	<img class="weatherImgEx" src="${imgUrl}" />
	H: <c:out value="${weatherList.highFar }" /> / L: <c:out value="${weatherList.lowFar}" />
	</c:forEach>
	</div>
</div>
</body>
</body>
