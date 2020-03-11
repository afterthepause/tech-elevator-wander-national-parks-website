<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:url var="imgUrl" value="/img/parks/${park.parkCode.toLowerCase()}.jpg" />

<img src="${imgUrl}"/>