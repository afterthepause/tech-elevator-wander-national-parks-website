<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
<c:param name="Wander: Your National Parks Resource" value="homepage" />
</c:import>


<div id="homepage">

<body class="parklisting">
<c:forEach var="park" items="${parks}">

<c:url var = "parkDetailURL" value = "/parkDetail">
<c:param name = "currentParkCode" value = "${park.parkCode}"/>
</c:url>

<h1 class="${park.parkCode}name"><c:out value = "${park.parkName}"/></h1>

<a class="${park.parkCode}img" href="${parkDetailURL}"><c:url var="imgUrl" value="/img/parks/${park.parkCode.toLowerCase()}.jpg" />
<img src="${imgUrl}"/>
</a>

<p class="${park.parkCode}description">
<c:out value = "${park.parkDescription}"/>
</p>


</c:forEach>
</div>
</div>

</body>































</div>