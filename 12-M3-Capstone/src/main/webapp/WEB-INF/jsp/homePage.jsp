<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="homepage">

<ol>
<c:forEach var="park" items="${parks}">

<c:url var="imgUrl" value="/img/parks/${park.parkCode.toLowerCase()}.jpg" />
<img src="${imgUrl}" />
${park.parkName}
<p class="description">
${park.parkDescription }
</p>
<br>



</c:forEach>
</ol>































</div>