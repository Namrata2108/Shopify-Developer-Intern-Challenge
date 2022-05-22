<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="UserSignupStyles.css">
<meta charset="ISO-8859-1">
<title>Customer Sign Up Page</title>
<link rel="stylesheet" href="/app.css">

</head>
<body>
	<!-- <form action="/editproduct" method="post" id="AddProduct"> action="editproduct"-->
	<form:form modelAttribute="product2" method="post"  >

		<div class="UserContainer">
			<label>
				Update Category
			</label>
		</div>
		<br><br>
	
		<%-- <div class="UserContainer">
			<label>Category ID</label>
			<form:input path="id" value="${product2.getId()}" type="text" required="required"/>
		</div> --%>
		<br><br>
		<div class="UserContainer">
			<label>Name</label>
			<form:input path="name" value="${product2.getName()}" type="text" required="required"/>
		</div>
		
		
		<br></br>
		<div class="UserContainer">
			<input type="submit" value="updateproduct" />
		</div>
	</form:form>
</body>
</html>

