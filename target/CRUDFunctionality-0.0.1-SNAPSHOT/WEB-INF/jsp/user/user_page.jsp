<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />
<body>
	<div class="container">
		<h1>Users List</h1>
		<table width="100%">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Address</th>
				<th>Country</th>
				<th>Sex</th>
				<th colspan="2">Action</th>
			</tr>
			<c:forEach items="${listUser}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.address}</td>
					<td>${user.country}</td>
					<td>${user.sex}</td>
					<td><spring:url value="/user/update/${user.id}"
							var="updateURL" /> <button class="btn btn-primary" onclick="location.href='${updateURL}'">Update</button></td>
					<td><spring:url value="/user/delete/${user.id}"
							var="deleteURL" /> <button class="btn btn-danger" onclick="location.href='${deleteURL}'">Delete</button></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="../fragments/footer.jsp" />

</body>
</html>