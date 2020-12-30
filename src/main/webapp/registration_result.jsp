<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
    <%@ page import="com.project.model.OtpPin" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Details</title>
    <style>
        body{
        background-color: #3C9AE2;
        }
     	section{
     		width:400px;
     		margin : 0 auto;
           background-color: #F7F6F2;
           border-radius : 8px;
           text-align:center;
           padding:10px;     	
           position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);	
     	}
     	p{
     		font-size:18px;
     	}
    </style>
</head>
<body>
	<section>
	<h2>Registration successful</h2>
	<p>Your CustomerId is ${cusid}</p>
	<p>Your pin is ${pin}</p>		
	<p>Use this pin for login purpose</p>
	<a href="/">Login</a></p>
	</section>
</body>
</html>