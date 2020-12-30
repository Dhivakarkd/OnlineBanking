<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page isELIgnored="false"%>
    <%@ page import="com.project.model.OtpPin" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Details</title>
</head>
<style>
    body{
    background-color: #3C9AE2;
    }
	main{
	margin : 0 auto;
    background-color: #F7F6F2;
    text-align : center;
	width:700px;
	border-radius : 8px;
	padding : 20px;
	box-sizing: border-box;
	}
	table{
	border : 1px solid black;
	border-collapse : collapse;
	width:100%;
	}
	td,th{padding : 5px;	border : 1px solid black;}
	h2{
	margin : 15px 0;
	}
	.accNumber{
		padding : 10px 14px;
        background-color: #51BFA4;
        margin-bottom : 6px;
        display : inline-block;
        text-decoration : none;
        border-radius : 8px;
        color : black;
	}
	section,h3{text-align : left;}
</style>
<body>
<main>
<h2>Welcome ${customer.fname}!</h2>
<table class="viewtable">
	<tr>
		<th>Customer Id</th>
		<th>First name</th>
		<th>Middle name</th>
		<th>Last name</th>
		<th>City</th>
		<th>Mobile no</th>
		<th>Occupation </th>
		<th>Date of Birth</th>	
	</tr>	
		
	<tr>
		<td>${customer.customerId}</td>
		<td>${customer.fname}</td>
		<td>${customer.mname}</td>
		<td>${customer.ltname}</td>
		<td>${customer.city}</td>	
		<td>${customer.mobileno}</td>
		<td>${customer.occupation}</td>
		<td>${customer.dob}</td>					
	</tr>		
	
</table>
<section>
	<h3>Account Details</h3>
	<table>
	<tr>
		<th>Account Number</th>
		<th>Account Type</th>
		<th>Account Status</th>
	
	</tr>
	<c:forEach items="${account}" var="temp">
		<tr>
			<td><a href="/transactionDetails/${temp.accountNumber}">${temp.accountNumber}</a></td>
			<td>${temp.accountType}</td>
			<td>${temp.accountStatus}</td>
			
			
		</tr>
	              
    </c:forEach>
	
	</table>
	
</section>

</main>

</body>
</html>