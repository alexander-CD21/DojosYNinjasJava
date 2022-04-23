<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>New Ninja</h2>

<form:form action="/ninja/new" method="post" modelAttribute="ninja">
            	<form:label path="dojo.name"> Dojo </form:label>
            	<form:select path = "dojo.name">
                     <form:option value = "NONE" label = "Select"/>
                     <form:options items = "${dojos}" />
                </form:select>
            
            <p>
                <form:label path="firstName">FirstName</form:label>
                <form:errors path="firstName"/>
                <form:input path="firstName"/>
            </p>
            
            
            <p>
                <form:label path="lastName">LastName</form:label>
                <form:errors path="lastName"/>
                <form:input path="lastName"/>
            </p>
           
            <p>
                <form:label path="age">Age</form:label>
                <form:errors path="age"/>
                <form:input path="age"/>
            </p>
            <input type="submit" value="Create"/>
            
        </form:form>

</body>
</html>