<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<link href="https://fonts.googleapis.com/css?family=Amatic+SC|Open+Sans+Condensed:300&display=swap" rel="stylesheet">
<c:url var="cssUrl" value="/css/main.css" />
<link rel="stylesheet" href="${cssUrl}" />
</head>
<div class="wrapper">
<div class="header">
<c:url var="logo" value="/img/wander.png" />
<img class="logo" src="${logo}"/>
<br>
<hr>
<div class="links">
<c:url var="homebutton" value="/img/homebutton.png" />
<a href = "<c:url value="/"/>"><img class="homebutton" src="${homebutton}" /></a>
&emsp;
<c:url var="surveybutton" value="/img/surveybutton.png" />
<a href = "<c:url value="/survey"/>"><img class="surveybutton" src="${surveybutton }" /></a>
</div>
</div>
</div>
<br><br>