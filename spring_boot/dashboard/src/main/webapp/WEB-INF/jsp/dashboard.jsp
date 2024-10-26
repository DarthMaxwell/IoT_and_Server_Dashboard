<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/simple.css">
	<script src="js/myscript.js" defer></script>  
<title>Dashboard</title>
</head>
<body>
	<h2>Dashboard</h2>
	<p>last updated</p>
	<h3>${host1}</h3>
	<p>${host1} is ${(host1Ping) ? "alive" : "dead"} and port ${host1Port} is ${(host1PortCon) ? "open" : "closed"}</p>

	<h3>${host2}</h3>
	<p>${host2} is ${(host2Ping) ? "alive" : "dead"} and port ${host2Port} is ${(host2PortCon) ? "open" : "closed"}</p>
</body>
</html>