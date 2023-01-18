<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

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
</head>

<body onload="runClock()">

	<nav class="navbar navbar-expand-lg navbar-light bg-primary">
		<a class="nav-link text-white" href="employees">Employee</a> <span
			id="time" class="text-white ml-3"></span>
		<div class="col text-right">
			<a class="nav-link text-white" href="loggedout">Logout</a>
		</div>
	</nav>
	<div class="d-flex justify-content-center">

		<form class="form border col-4" action="update" method="post">
			<h4>Edit Employee</h4>
			<div class="form-group col-10 text-center">
				<label>Prénom</label> <input type="text" class="form-control"
					name="firstName" value="${emp.firstName }">
			</div>
			<div class="form-group col-10 text-center">
				<label>Nom</label> <input type="text" class="form-control"
					name="lastName" value="${emp.lastName }">
			</div>
			<div class="form-group col-10 text-center">
				<label>Poste</label> <input type="text" class="form-control"
					name="title" value="${emp.title }">
			</div>
			<div class="form-group col-10 text-center">
				<label>Date de début</label> <input type="date" class="form-control"
					name="startDate" value="${emp.startDate }">
			</div>
			<input type="hidden" class="form-control" name="empId"
				value="${emp.empId }"> <input type="submit"
				class="btn btn-info" value="Modifier">

		</form>
	</div>
</body>
</html>