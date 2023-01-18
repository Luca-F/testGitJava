<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		<a class="nav-link text-white" href="employees">Employee</a>
		<span id="time" class="text-white ml-3"></span>
		<div class="col text-right">
			<a class="nav-link text-white" href="loggedout">Logout</a>
		</div>
	</nav>

	<div class="d-flex justify-content-center">

		<form class="form border col-4" action="save" method="post">
			<h4>Ajout employée</h4>
			<div>
				<div class="form-group col-10 text-center">
					<label>Prénom</label> <input type="text" name="firstName"
						class="form-control" required>
				</div>
				<div class="form-group col-10 text-center">
					<label>Nom</label> <input type="text" name="lastName"
						class="form-control" required>
				</div>
				<div class="form-group col-10 text-center">
					<label>Post</label> <input type="text" name="title"
						class="form-control" required>
				</div>
				<div class="form-group col-10 text-center">
					<label>Date de début</label> <input type="date"
						class="form-control" name="startDate" value="${emp.startDate }">
				</div>
			</div>
			<input type="submit" class="btn btn-success" value="Ajouter">
		</form>
	</div>
</body>
</html>