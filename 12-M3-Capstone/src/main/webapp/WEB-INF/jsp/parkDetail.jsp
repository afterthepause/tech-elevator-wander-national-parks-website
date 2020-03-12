<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/jsp/common/header.jsp">
<c:param name="Wander: Your National Parks Resource" value="homepage" />
</c:import>

<body class="parklisting">
<h1 class="pagedetailh1"><c:out value="${park.parkName}" /></h1>
<p class="quote">"<c:out value="${park.inspirationalQuote}" />"
<br>
-<c:out value="${park.inspirationalQuoteSource}" />
<br>
</p>
<c:url var="imgUrl" value="/img/parks/${park.parkCode.toLowerCase()}.jpg" />
<img class="pagedetailimg" src="${imgUrl}"/>
<div>
<p class="pagedetaildescription">
<c:out value="${park.parkDescription}" />
</p>
</div>
<div class="table">
<table>
<tr><th class="header">Park Facts</th><tr>

<tr><td class="one">Location: <c:out value="${park.state}" /></td></tr>

<tr><td class="two">Park Size: <c:out value="${park.acreage}" /> acres</td></tr>

<tr><td class="one">Elevation: <c:out value="${park.elevationInFeet}" /> feet</td></tr>

<tr><td class="two">Miles of Trail: <c:out value="${park.milesOfTrail}" /> miles</td></tr>

<tr><td class="one">Number of Campsites <c:out value="${park.numberOfCampsites}" /> </td></tr>

<tr><td class="two">Climate: <c:out value="${park.climate}" /></td></tr>

<tr><td class="one">Year Founded: <c:out value="${park.yearFounded}" /></td></tr>

<tr><td class="two">Annual Visitor Count: <c:out value="${park.annualVisitorCount}" /></td></tr>

<tr><td class="one">Entry Fee: <c:out value="${park.entryFee}" /></td></tr>

<tr><td class="two">Animal Species: <c:out value="${park.numberOfAnimalSpecies}" /> </td></tr>
</table>
</div>
</div>