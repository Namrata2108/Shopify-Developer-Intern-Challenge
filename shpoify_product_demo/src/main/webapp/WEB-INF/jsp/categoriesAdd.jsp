<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="UserSignupStyles.css">
<meta charset="ISO-8859-1">
<title>Add Product</title>
<link rel="stylesheet" href="/app.css">

</head>
<body>
	<%-- <form action="/addproduct" method="post" id="AddProduct"> --%>
	<form:form modelAttribute="product1" method="post" >

		<div class="UserContainer">
			<label>
				Add Category
			</label>
		</div>
	
		<br><br>
		<table>
		<%-- <tr>
				<td>Category ID:</td>
				<td><form:input path="id" size="30" required="required"/> </td>
			</tr> --%>
	
		<tr>
				<td>Name:</td>
				<td><form:input path="name" size="30" required="required"/> </td>
			</tr>
		
			<tr>
				<td colspan="2"><input type="submit" value="Add Category" /></td>
			</tr>
		
		
	</table>

	</form:form>
</body>
</html>
