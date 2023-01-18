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
			<a class="nav-link text-white" href="logout">Logout</a>
		</div>
	</nav>

	<form action="delete" method="post">
		<h4>Supprimer employé</h4>
		<p>Etes-vous sûr de vouloir le supprimer?</p>
		<p class="text-warning">
			<small>Cette action est définitive</small>
		</p>
		<input type="hidden" class="form-control" name="empId"
			value="${emp.empId }"> <input type="submit"
			class="btn btn-danger" value="Supprimer">
	</form>
</body>
</html>