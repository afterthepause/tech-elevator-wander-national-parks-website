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


<div class="weather">
<c:forEach var="weatherList" items="${weatherList }">

<c:out value="${weatherList.fiveDayForecastValue}" />
<c:url var="imgUrl" value="/img/weather/${weatherList.forecast}.png" />
<img class="weatherimg" src="${imgUrl}" />
<c:out value="${weatherList.lowFar }" />
<c:out value="${weatherList.highFar}" />
</c:forEach>





</div>
</div>
</body>
</body>
