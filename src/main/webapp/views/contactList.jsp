<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Phone</th>
			<th>Email</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${contactList}" var="contact">
			<tr>
				<td>${contact.name}</td>
				<td>${contact.phoneNo}</td>
				<td>${contact.email}</td>
				<td><a href="editContact/${contact.id}">Edit </a></td>
				<td><a
					href="${pageContext.request.contextPath}/deleteContact/${contact.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>