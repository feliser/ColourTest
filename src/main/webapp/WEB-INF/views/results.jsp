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
      <canvas id="results-canvas" width="2000px" height="80px">Sorry, your browser doesn't support the &lt;canvas&gt; element.</canvas>
      <div class="text-center">
        <h3>Black Line: Your Score<br>Red Line: Average Score</h3>
      </div>
    </div>
    <div class="text-center">
      <h4>What do These Results Mean?</h4>
      <p>These results display your middleground between ${leftColor} and ${rightColor} (shown with the black line) compared to the average of others who took the test (shown with the red line).  
      </p>
      <a href="/" class="btn btn-start" id="start-button"><span>Back to Main Page</span></a>
    </div>
    <footer class="py-5 bg-black">
      <div class="container">
        <p class="m-0 text-center text-white small">Copyright &copy; <a href="https://www.github.com/feliser">feliser</a> 2020</p>
      </div>
    </footer>
  	<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script>
      var c = document.getElementById("results-canvas");
      var ctx = document.getElementById("results-canvas").getContext("2d");
      c.style.backgroundImage="linear-gradient(90deg,${leftColor},${rightColor})";
      ctx.beginPath();
      ctx.moveTo(c.width * ${score}, 0);
      ctx.lineTo(c.width * ${score}, c.height/2.0);
      ctx.lineWidth = 20;
      ctx.strokeStyle = "#FFFFFF";
      ctx.stroke();
      ctx.beginPath();
      ctx.moveTo(c.width * ${score}, 0);
      ctx.lineTo(c.width * ${score}, c.height/2.0);
      ctx.lineWidth = 16;
      ctx.strokeStyle = "#000000";
      ctx.stroke();
      ctx.beginPath();
      ctx.moveTo(c.width * ${average}, c.height/2.0);
      ctx.lineTo(c.width * ${average}, c.height);
      ctx.lineWidth = 20;
      ctx.strokeStyle = "#FFFFFF";
      ctx.stroke();
      ctx.beginPath();
      ctx.moveTo(c.width * ${average}, c.height/2.0);
      ctx.lineTo(c.width * ${average}, c.height);
      ctx.lineWidth = 18;
      ctx.strokeStyle = "#FF0000";
      ctx.stroke();
    </script>
  </body>
</html>
