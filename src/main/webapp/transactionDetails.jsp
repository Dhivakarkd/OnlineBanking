<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction Details</title>
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
</style>
</head>
<body>
	<main>
	
	<table>
		<h2>Your account transaction details</h2>
		<tr>
		<th>Transaction number</th>
		<th>Date of transaction</th>
		<th>Medium of transaction</th>
		<th>Transaction type </th>
		<th>Transaction amount</th>
		</tr>
		
		<c:forEach items="${transaction}" var="temp">
		<tr>
		
			<td>${temp.id}</td>
			<td>${temp.date}</td>
			<td>${temp.mediumofTrans}</td>
			<td>${temp.type}</td>
			<td>${temp.amount}</td>
		
			
			
		</tr>
	              
    	</c:forEach>
			

	</table>
	<h3>Available Balance is ${Balance}</h3>
	</main>
</body>
</html>