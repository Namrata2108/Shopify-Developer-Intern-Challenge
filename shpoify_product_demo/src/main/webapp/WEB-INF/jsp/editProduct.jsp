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
	<form:form modelAttribute="product" method="post"  >

		<div class="UserContainer">
			<label>
				Update Product
			</label>
		</div>
		<br><br>
	
		<div class="UserContainer">
			<label>Product ID</label>
			<form:input path="product_id" value="${product.getProduct_id()}" type="text" required="required"/>
		</div>
		<br><br>
		<div class="UserContainer">
			<label>Book Name</label>
			<form:input path="bookName" value="${product.getBookName()}" type="text" required="required"/>
		</div>
		 <div class="UserContainer">
			 
                    <label for="category">Select Category</label>
                                                     
                    <%-- <select path="categoryId" id="category" name="category">
    <c:forEach items="${categories}" var = "category">
        <option value="${category.id}">${category.name}</option>
    </c:forEach>
</select> --%>
                </div> 
		<div class="UserContainer">
			<label>Price</label>
			<form:input path="price" value="${product.getPrice()}" type="text" required="required"/>
		</div>
		<%-- <div class="UserContainer">
			<label>Category</label>
			<form:input path="category" value="${product.getCategory()}" type="text" required="required"/>
		</div> --%>
		
		
		
		<br></br>
		<div class="UserContainer">
			<input type="submit" value="updateproduct" />
		</div>
	</form:form>
</body>
</html>

