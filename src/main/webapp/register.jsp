 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib 
uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <style>
        *{
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }
        body{
            background-color: #3C9AE2;
        }
        .signUp{
            background-color: #F7F6F2;
            padding: 40px;
            border-radius: 8px;
            width: 400px;
            margin: 50px auto;
            text-align: center;
        }
        .signUp h2{
            margin-bottom: 10px;
        }
        .signUp input{
            margin: 15px 0 0 0;
            width: 250px;
            height: 40px;
            border-radius: 8px;
            padding: 10px;
            outline: none;
            border: none;
            background-color: #EBE6E2;
        }
        .signUp input:focus{
            outline: none;
        }
        .signUp p{
            text-align: left;
            margin-left: 40px;
            font-size: 12px;
            color:red;
            margin-top: 6px;
            display:none;
        }
        .showError{display:block;
        color: red;}
        .submitBtn{
            padding: 10px 40px;
            border-radius: 8px;
            border: none;
            margin-top: 25px;
            margin-bottom: 15px;
            background-color: #51BFA4;
            color: white;
        }
        .submitBtn:hover{
            background-color: grey;
            cursor: pointer;
        }

    </style>
</head>
<body>
	<form:form method="post" action="registeruser" modelAttribute="customer" class="signUp">
        <h2>SignUp</h2>
        
       
        <form:input path="fname" placeholder="Enter First Name"/>
        <form:errors path="fname" cssClass="showError"/>
        <br>
       
        <form:input path="mname" placeholder="Enter Middle Name"/><form:errors path="mname" cssClass="showError"/><br>
        
        <form:input path="ltname" placeholder="Enter Last Name"/><form:errors path="ltname" cssClass="showError"/><br>
       
        <form:input path="city" placeholder="Enter City Name"/><form:errors path="city" cssClass="showError"/><br>
        
        <form:input path="mobileno" placeholder="Enter Mobile No "/><form:errors path="mobileno" cssClass="showError"/><br>
       
        <form:input path="occupation" placeholder="Enter Occupation"/><form:errors path="occupation" cssClass="showError"/><br>
     
        <form:input path="dob" type="date" /><form:errors path="dob" cssClass="showError"/><br>
    
        <button class="submitBtn" type="submit">SignUp</button>
    </form:form>
</body>
</html>