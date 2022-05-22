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
	<form:form modelAttribute="product" method="post" >

		<div class="UserContainer">
			<label>
				Add Product
			</label>
		</div>
	
		<br><br>
		<table>
		<tr>
				<td>Product ID:</td>
				<td><form:input path="product_id" size="30" required="required"/> </td>
			</tr>
	
		<tr>
				<td>Book Name:</td>
				<td><form:input path="bookName" size="30" required="required"/> </td>
			</tr>
			 <tr>
			 
                    <label for="category">Select Category</label>
                     <select path="categoryId" id="category" name="category">
    <c:forEach items="${categories}" var = "category">
        <option value="${category.id}">${category.name}</option>
    </c:forEach>
</select>
                </tr>
			<tr>
				<td>Price:</td>
				<td><form:input path="price" size="30" required="required"/> </td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="Add product" /></td>
			</tr>
		
		
	</table>

	</form:form>
</body>
</html>
