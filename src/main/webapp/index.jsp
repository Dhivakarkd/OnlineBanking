<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib 
uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OnlineBankingPortal</title>
<style>
        *{
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }
        body{
            background-color: #3C9AE2;
        }
        .loginForm{
            background-color: #F7F6F2;
            padding: 40px;
            border-radius: 8px;
            width: 400px;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
            text-align: center;
        }
        .loginForm h2{
            margin-bottom: 10px;
        }
        .loginForm input{
            margin: 15px 0 8px 0;
            width: 250px;
            height: 40px;
            border-radius: 8px;
            padding: 10px;
            outline: none;
            border: none;
            background-color: #EBE6E2;
        }
        .loginForm input:focus{
            outline: none;
        }
        .loginForm button{
            padding: 10px 40px;
            border-radius: 8px;
            border: none;
            margin-top: 15px;
            margin-bottom : 15px;
            background-color: #51BFA4;
            color: white;
        }
        .loginForm button:hover{
            background-color: grey;
            cursor: pointer;
        }
		.error{
            display:none;
			font-size:12px;
			color:red;
			text-align:left;
			margin-left:40px;
		}
		p.showError{
			display:block;
		}
</style>
</head>
<body>
<form method="post" action="/login"  class="loginForm">
<h2>Login</h2>
<input type="text" name="id" placeholder="Enter Customer ID">
<p class="error" id="customerId">*invalid customer id</p>
<input type="password" name="password" placeholder="Enter your Password">
<p class="error" id="customerId">*invalid password</p>
<button type="submit" >Login</button>
<p>Not having an account ? <a href="/register">Sign Up</a></p>

</form>

</body>
</html>