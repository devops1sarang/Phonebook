<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${success} ${error}

	<form:form method="post" modelAttribute="contactDto"
		action="${pageContext.request.contextPath}/saveContact">
		<table>
			<tr>
				<td>Name</td>
				<td><form:input path="name" /></td>
				<form:hidden path="id"/>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" /></td>
			</tr>

			<tr>
				<td>Phone Number</td>
				<td><form:input path="phoneNo" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form:form>
	
	<a href="${pageContext.request.contextPath}/showAllContacts">Show All Contacts</a>

</body>
</html>