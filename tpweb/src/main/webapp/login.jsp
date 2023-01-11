<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Fonts -->
<link rel="dns-prefetch" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600"
	rel="stylesheet" type="text/css">

<link rel="stylesheet" href="css/style.css">

<link rel="icon" href="Favicon.png">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">

<title>Tp user</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navabr-brand" href="index.html">Accueil</a>
	</nav>

	<h2>Se connecter</h2>
	<h3>${message}</h3>
	<form action="login" method="post">
		<div class="form-group">
			<label for="email">Email :</label> 
			<input type="text"
				class="form-control input" name="email" id="email"
				placeholder="Veuillez saisir votre mail">
		</div>

		<div class="form-group">
			<label for="password">Password :</label> 
			<input type="password"
				class="form-control input" name="password" id="password"
				placeholder="Saisir mot de passe" required>
		</div>
		<button type="submit" class="btn btn-primary">Connexion</button>
	</form>
</body>
</html>

