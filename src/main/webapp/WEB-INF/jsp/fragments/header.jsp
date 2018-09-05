<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<title>Spring MVC Form Handling Example</title>

<spring:url value="/resources/core/css/crud.css" var="crudCss" />
<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${crudCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
<link href="${bootstrapCss}" rel="stylesheet" />
</head>

<spring:url value="/user/add" var="addURL" />

<nav class="bg-header navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-title navbar-header">
			<a class=" navbar-brand">Spring CRUD Functionality</a>
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${addURL}">Add User</a></li>
			</ul>
		</div>
	</div>
</nav>