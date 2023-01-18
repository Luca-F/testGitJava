<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TP form</title>
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
		<a class="text-white">WebGest</a>
		
		<div class="col text-right">
			<span id="time" class="text-white ml-2"></span>
		</div>
	</nav>

	<div class="d-flex justify-content-center">
	
	<form class="form border col-4" action="login" method="post">
	<h2 class="my-auto col-10">Se connecter</h2>
	<h5 class="small text-danger m-1">${message}</h5>
	
		<div class="form-group col-10 text-center">
			<label for="email">Email :</label> <input type="text"
				class="form-control justify-content-center input" name="email" id="email"
				placeholder="Veuillez saisir votre mail" required>
		</div>

		<div class="form-group col-10 text-center">
			<label for="password">Password :</label> <input type="password"
				class="form-control justify-content-center input" name="password" id="password"
				placeholder="Saisir mot de passe" required>
		</div>
		<button type="submit" class="btn btn-primary">Connexion</button>
	</form>
</div>
</body>
</html>