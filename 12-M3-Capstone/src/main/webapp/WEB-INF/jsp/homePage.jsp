<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="homepage">


<c:forEach var="park" items="${parks}">

<c:url var = "parkDetailURL" value = "/productDetail">
<c:param name = "currentParkCode" value = "${park.parkCode}"/>
</c:url>


<c:url var="imgUrl" value="/img/parks/${park.parkCode.toLowerCase()}.jpg" />

<a href="${parkDetailURL}">
<img src="${imgUrl}"/>
</a>

<h1><c:out value = "${park.parkName}"/></h1>

<p class="description">
<c:out value = "${park.parkDescription}"/>
</p>

<br>



</c:forEach>
































</div>