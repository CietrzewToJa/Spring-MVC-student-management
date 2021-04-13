<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student's data</title>

<link rel="stylesheet" type="text/css" href="/student-management/URLToReachResourcesFolder/css/my-style-sheet.css">

</head>
<body>

	<h1 align="center">Student management</h1>

	<div align="center">
	
		<form action="/student-management/showAddStudentPage">
			<input type="submit" value="Add">
		</form>
		<br/>
	
		<table border="1">

			<thead>
				<tr>
					<td>id</td>
					<td>name</td>
					<td>mobile</td>
					<td>country</td>
					<td></td>
					<td></td>
				</tr>
			</thead>

			<c:forEach var="student" items="${students}">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.mobile}</td>
					<td>${student.country}</td>
					<td><a href="/student-management/updateStudent?userId=${student.id}">Update</a></td>
					<td><a href="/student-management/deleteStudent?userId=${student.id}" onclick="if(!(confirm('Are you sure you want to delete ehis student?'))) return false">Delete</a></td>
				</tr>

			</c:forEach>
		</table>
	</div>

</body>
</html>