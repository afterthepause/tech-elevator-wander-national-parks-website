<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


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
</div>
</div>



<div id="weatherComplete">
	<c:url var="actionUrl" value="/changeWeather">
	<c:param name="currentParkCode" value="${param.currentParkCode}"/>
	</c:url>

<div class="weatherSelector">
	<p class="fiveDay">5 Day Weather Forecast:</p><br>
	<div class="tempConvert">
	<p class="choose">View Temperature in:&nbsp;&nbsp;
	<form method="POST" action="${actionUrl}">
		<select name="isCelsius">
			<option value="false" ${isCelsius ? '' : 'selected'}>Fahrenheit</option>
			<option value="true" ${isCelsius ? 'selected' : ''}>Celsius</option>
		</select>
		<input type="submit" name="submit" class="btn btn-success" value="Go"/>
	</form>
	</div>
</div>

<div class="todayWeather">
		<%-- <fmt:parseDate tyle="date" pattern="yyyy-MM-dd" value="${weatherList.getForecastDate(i)} var="date" />
		<fmt:formatDate value="${date}" />
		<c:set var="i" value="${i +1 }" />--%>
		<c:set var="weather" value="${weatherList[0]}" /> 
			<c:url var="weatherImg" value="/img/weather/${weather.forecast}.png" />
			<img src="${weatherImg}" />
			<br>
			<span class="forecast"><c:out value="${weather.forecast }" /><br>
			
			<c:choose>
			<c:when test="${isCelsius}">
			H: <fmt:formatNumber type="Number" value= "${(weather.high - 32) / 1.8}" maxFractionDigits="0"/>
			| L: <fmt:formatNumber type="Number" value="${(weather.low - 32) / 1.8}" maxFractionDigits="0"/>
			<c:set var="tempScale" value="°C" />
			</c:when>
			<c:otherwise>
		
			H: <c:out value="${weather.high}" />
			| L:<c:out value="${weather.low}" />
			<c:set var="tempScale" value="°F" />
			</c:otherwise>
			</c:choose> 
			<br>
			<c:out value="${weatherList[0].tempMessage }" /><br>
			<c:out value="${weatherList[0].forecastMessage}" />
			</span>
</div>

<div class="extendedWeather">
		<c:forEach varStatus="loop" var="weather" items="${weatherList}" begin="1">
		<div class="days">
		<c:set var="weather" value="${weatherList[loop.index]}" />
		<br>
		
		<c:url var="weatherImg" value="/img/weather/${weather.forecast}.png" />
		<img src="${weatherImg} " />
		<br>
		
		<span class="extWeather">
		<c:out value="${weather.forecast }" />
		<br>
		<c:choose>
			<c:when test="${isCelsius}">
			H: <fmt:formatNumber type="Number" value= "${(weather.high - 32) / 1.8}" maxFractionDigits="0"/>
			| L: <fmt:formatNumber type="Number" value="${(weather.low - 32) / 1.8}" maxFractionDigits="0"/>
			<c:set var="tempScale" value="°C" />
			</c:when>
			<c:otherwise>
		
			H: <c:out value="${weather.high}" />
			| L:<c:out value="${weather.low}" />
			<c:set var="tempScale" value="°F" />
			</c:otherwise>
		</c:choose> 
			 
		<br>
		</span>
		<%-- <c:out value="${weather.tempMessage }" />
		<br>
		<c:out value="${weather.forecastMessage}" />
		 --%>
	</div>
		</c:forEach>
		
	</div>

</div>
</body>