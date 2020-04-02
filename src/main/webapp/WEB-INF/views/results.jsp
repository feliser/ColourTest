<!DOCTYPE html>
<html lang="en">
  <head lang="en">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">	
	<title>ColorTest Results</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/results.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i" rel="stylesheet">
  </head>
  <body>
  	<header id="masthead" class="masthead text-center text-white">
      <div class="masthead-content">
        <div class="container">
          <h1 class="masthead-heading mb-0">Results</h1>
        </div>
      </div>
      <div class="bg-circle-1 bg-circle"></div>
      <div class="bg-circle-2 bg-circle"></div>
      <div class="bg-circle-3 bg-circle"></div>
      <div class="bg-circle-4 bg-circle"></div>
    </header>
    <div class="card">
      <canvas id="results-canvas" width="300px" height="300px">Sorry, your browser doesn't support the &lt;canvas&gt; element.</canvas>
    </div>
  	<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script>
      document.getElementById("results-canvas").style.backgroundImage="linear-gradient(90deg,${leftColor},${rightColor})";
    </script>
  </body>
</html>