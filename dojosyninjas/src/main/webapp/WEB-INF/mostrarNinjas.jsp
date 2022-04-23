<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mostrando Ninjas</title>
</head>
<body>
	<h1>Burbank Location Ninjas </h1>
    <table>
        <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="ninja" items="${ninjas}">
                <tr>
                    <th><c:out value="${ninja.firstName}"></c:out></th>
                    <th><c:out value="${ninja.lastName}"></</c:out></th>
                    <th><c:out value="${ninja.age}"></</c:out></th>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>