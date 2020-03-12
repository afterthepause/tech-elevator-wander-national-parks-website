<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/jsp/common/header.jsp">
<c:param name="Wander: Your National Parks Resource" value="homepage" />
</c:import>

<h1><c:out value="${park.parkName}" /></h1>
<p>"<c:out value="${park.inspirationalQuote}" />"
<br>
-<c:out value="${park.inspirationalQuoteSource}" />
<br>
</p>
<c:url var="imgUrl" value="/img/parks/${park.parkCode.toLowerCase()}.jpg" />
<img src="${imgUrl}"/>
<div>
<c:out value="${park.parkDescription}" />
<h3>Park Facts</h3>
Location: <c:out value="${park.state}" />
<br>
Park Size: <c:out value="${park.acreage}" /> acres
<br>
Elevation: <c:out value="${park.elevationInFeet}" /> feet
<br>
Miles of Trail: <c:out value="${park.milesOfTrail}" /> miles
<br>
Number of Campsites <c:out value="${park.numberOfCampsites}" /> 
<br>
Climate: <c:out value="${park.climate}" />
<br>
Year Founded: <c:out value="${park.yearFounded}" />
<br>
Annual Visitor Count: <c:out value="${park.annualVisitorCount}" />
<br>
Entry Fee: <c:out value="${park.entryFee}" />
<br>
Number of Animal Species within <c:out value="${park.parkName}" />: <c:out value="${park.numberOfAnimalSpecies}" /> different species

</div>