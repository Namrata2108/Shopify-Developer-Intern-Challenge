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
    <div id = "categories">
    <table>
    <tr>
        <th>Warehouse Id</th>
        <th> Name</th>
      
        <th>Edit</th>
        <!-- <th>Delete</th> -->
        
    </tr>
    
        <c:forEach items="${categories}" var = "var">
                        <tr>
                       <td> "${var.id}" </td>  
                        <td> "${var.name}" </td> 
                      
                        
                        <td><a href="<c:url value='/welcome/categories/update/${var.id}' />" >Edit</a></td>
                        <!-- Once added you can't delete the warehouse location but you can update it -->
						<%-- <td><a href="<c:url value='/welcome/categories/delete/${var.id}' />" >Delete</a></td> --%>									
                        </tr>   
                        
        </c:forEach> 
        </table>
        <a href="<c:url value='/welcome/categories/add' />" >Add Category</a>
        <a href="<c:url value='/welcome' />" >Home</a>
        
       
    </div>
</body>
</html>

