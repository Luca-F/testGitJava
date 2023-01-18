<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
<script
	src="https://unpkg.com/bootstrap-table@1.21.2/dist/bootstrap-table.min.js"></script>

<script>
	function runClock() {
		today = new Date();
		hours = today.getHours();
		minutes = today.getMinutes();
		seconds = today.getSeconds();
		timeValue = hours;
		timeValue += ((minutes < 10) ? ":0" : ":") + minutes;
		timeValue += ((seconds < 10) ? ":0" : ":") + seconds;
		document.getElementById("time").innerHTML = timeValue;
		timerID = setTimeout(runClock, 1000);
		timerRunning = true;
	}
</script>
<link rel="stylesheet"
	href="https://unpkg.com/bootstrap-table@1.18.2/dist/bootstrap-table.min.css">
</head>

<body onload="runClock()">

	<nav class="navbar navbar-expand-lg navbar-light bg-primary">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link text-white"
					href="employees">Employees</a></li>
				<li class="nav-item active"><a class="nav-link text-white"
					href="save">Ajouter un employé</a></li>
				<!-- <li class="nav-item"><a class="nav-link" href="logout">Logout</a>
				</li> -->
				
			</ul>
			<span id="time" class="text-white ml-3"></span>
		</div>
		
		<div class="col text-right">
			<a class="nav-link text-white" href="loggedout">Logout</a>
		</div>
	</nav>

	<h3>Liste des employés</h3>

	<c:set var="employees" value="${employees}" />
	<c:if test="${ not empty employees}">

		<table class="table-bordered" data-toggle="table"
			data-pagination="true" data-search="true" data-page-size="[5]"
			data-page-list="[5, 10, 15, all]">
			<thead>
				<tr>
					<th>Id employé</th>

					<th>Prénom</th>

					<th>Nom</th>

					<th>Date de début</th>

					<th>Poste</th>

					<th>Modification</th>

					<th>Supprimer</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employees}" var="employee">
					<tr>
						<td>${employee.empId}</td>
						<td>${employee.firstName}</td>
						<td>${employee.lastName}</td>
						<td>${employee.startDate}</td>
						<td>${employee.title}</td>
						<td><a class="btn btn-warning"
							href="update?empId=${employee.empId}"><i
								class="bi bi-plus-circle-fill"></i></a></td>
						<td><a class="btn btn-danger"
							href="delete?empId=${employee.empId}"><i
								class="bi bi-dash-circle-fill"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>
