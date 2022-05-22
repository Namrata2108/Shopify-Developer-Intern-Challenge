<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="UserSignupStyles.css">
<meta charset="ISO-8859-1">
<title>Customer Sign Up Page</title>
<link rel="stylesheet" href="/app.css">

</head>
<body>
	<form action="/addproduct" method="post" id="AddProduct">

		<div class="UserContainer">
			<label>
				Update Product
			</label>
		</div>
		<br><br>
		<div class="UserContainer">
			<span>
				<c:forEach items="${Errors}" var = "error">
					<p> Error: "${error}" </p> <br></br>
				</c:forEach>
			</span>
		</div>
		<br><br>
		<div class="UserContainer">
		<%-- <c:forEach items="${Data2}" var = "error">
					<p> Error: "${Data2.product}" </p> <br></br>
				</c:forEach> --%>
				
			<label>Product ID</label>
			<input name="product_id" type="text" required/>
		</div>
		<br><br>
		<div class="UserContainer">
			<label>Book Name</label>
			<input name="bookName" type="text" required/>
		</div>
		<div class="UserContainer">
			<label>Price</label>
			<input name="price" type="text" required/>
		</div>
		
		
		<br></br>
		<div class="UserContainer">
			<input type="submit" value="Updateproduct" />
		</div>
	</form>
</body>
</html>