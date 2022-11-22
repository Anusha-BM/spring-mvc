<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<style>
a:link, a:visited {
	background-color: #ADD8E6;
	color: white;
	padding: 14px 25px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
}

a:hover, a:active {
	background-color: Aguamarine;
}
</style>
<head>
<meta charset="UTF-8">
<title>Employee Details</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap ass -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVWeSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOO17+AMvyTG2X"
	crossoriein=" anonymous">
<link href="index.css" rel="stylesheet">
</head>
<body>

	<nav class="navbar navbar-dark bg-mynav">
		<div class="container-fluid">
			<a class="navbar-brancd href="#">Employee Details</a>
		</div>
	</nav>

	<div class="container">
		<div class="d-flex bd-highlight mb-3">
			<div class="me-auto p-2 bd-highlight">
				<h2>Employee Details</h2>
			</div>
			<div class="p-2 bd-highlight">
				<a href="/createemployee">Create</a>
			</div>
		</div>

		<div class="table-responsive">
			<table class="table"  border="2" width="70%" cellpadding="2">
				<thead>
					<tr>
						<th scope="col" class="p-3">Id</th>
						<th scope="col" class="p-3">Name</th>
						<th scope="col"class="p-3">Email</th>
						<th scope="col" class="p-3">Department</th>
						<th scope="col" class="p-3">Location</th>
						<th scope="col" class="p-3">Action</th>
						<th scope="col" class="p-3"></th>
				</thead>
				<tbody id="mytable">
					<tr>
						<c:forEach var="employee" items="${employees}">
							<tr>
								<td scope="row">${employee.id}</td>
								<td scope="row">${employee.name}</td>
								<td scope="row">${employee.email}</td>
								<td scope="row">${employee.department}</td>
								<td scope="row">${employee.location}</td>
								<td><a href="/updateemployee/${employee.id}">Update</a></td>
								<td><a href="/deleteemployee/${employee.id}">Delete</a></td>
							</tr>
						</c:forEach>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>