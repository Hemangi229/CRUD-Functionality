<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />
<div class="container">

	<h1>Users Form</h1>
	<spring:url value="/user/save" var="saveURL" />
	<form:form modelAttribute="userForm" method="post" action="${saveURL}">
	
	<form:errors path="*" cssClass="errorblock" element="div"/>
	
		<form:hidden path="id" />
		<div class="col-sm-12">

			<spring:bind path="name">
				<div class="form-group">
					<label class="col-sm-2 control-label">Name</label>
					<form:input path="name" type="text" class="form-control col-sm-10"
						id="name" placeholder="Name" />
					<form:errors path="name" class="control-label" />
				</div>
			</spring:bind>

			<spring:bind path="email">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Email</label>
					<form:input path="email" type="text" class="form-control col-sm-10"
						id="email" placeholder="xyz@gmail.com" />
					<form:errors path="email" class="control-label" />
				</div>
			</spring:bind>

			<spring:bind path="address">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Address</label>
					<form:input path="address" type="text"
						class="form-control col-sm-10" id="address" placeholder="address" />
						<form:errors path="address" class="control-label" />
				</div>
			</spring:bind>

			<spring:bind path="country">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Country</label>
					<form:input path="country" type="text"
						class="form-control col-sm-10" id="country" placeholder="country" />
					<form:errors path="country" class="control-label" />	
				</div>
			</spring:bind>

			<spring:bind path="sex">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Sex</label> <label
						class="radio-inline"> <form:radiobutton path="sex"
							value="M" /> Male
					</label> <label class="radio-inline"> <form:radiobutton path="sex"
							value="F" /> Female
					</label> <br />
					<form:errors path="sex" class="control-label" />
				</div>
			</spring:bind>
			<button type="submit" class="btn-lg btn-primary pull-right">Save</button>
		</div>

	</form:form>
</div>
<jsp:include page="../fragments/footer.jsp" />

</body>
</html>