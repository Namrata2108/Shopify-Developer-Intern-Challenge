<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    
    <title>Show Product</title>
    <link rel="stylesheet" href="/app.css">
</head>
<body>
    <div id = "showproduct">
    <table>
    <tr>
        <th>Product Id</th>
        <th>Book Name</th>
        <th>Category</th>
        <th>Price</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    
        <c:forEach items="${Data1}" var = "var">
                        <tr>
                        <td> "${var.product_id}" </td> 
                        <td> "${var.bookName}" </td> 
                        <td> "${var.category.name}"</td>
                        <td> "${var.price}" </td> 
                       
                        
                        <td><a href="<c:url value='/welcome/showproductadmin/update/${var.product_uid}' />" >Edit</a></td>
						<td><a href="<c:url value='/welcome/showproductadmin/delete/${var.product_uid}' />" >Delete</a></td>
                        </tr>   
                        
        </c:forEach> 
        </table>
        <a href="<c:url value='/welcome/showproductadmin/addproduct' />" >Add Product</a>
        <a href="<c:url value='/welcome' />" >Home</a>
    </div>
</body>
</html>

