<!DOCTYPE html>
<html lang="en">
  <head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">	
	<title>${leftColor} vs. ${rightColor} - Test Your Color Perception</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/test.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i" rel="stylesheet">
  </head>
  <body>
    <div class="container">
	  <div class="card">
	    <div class="text-center">
          <h1>Is this color closer to ${leftColor} or ${rightColor}?</h1>
          <p id="counter">Pass 1/5</p>
		  <canvas id="color-canvas"></canvas>
	    </div>
	    <div class="btn-toolbar special">
  		  <button class="btn btn-left" id="left-button">${leftColor}</button>
	      <button class="btn btn-right" id="right-button">${rightColor}</button>
	    </div>
	    <button class="btn" id="submit-button" hidden>Submit Results</button>
	  </div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery.xcolor.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script>
		$("#left-button").html("${leftColor}");
		$("#right-button").html("${rightColor}");
		var counter = 1;
		var canvas = document.getElementById("color-canvas");
		var ctx = canvas.getContext("2d");
		var leftBound = "${leftColor}";
		var rightBound = "${rightColor}";
		var leftValue = 0.0;
		var rightValue = 1.0;
		ctx.fillStyle = $.xcolor.average(leftBound, rightBound);
		console.log($.xcolor.average(leftBound, rightBound));
		ctx.fillRect(0,0,canvas.width,canvas.height);
		$("#left-button").click(function() {
			$("#right-button").attr("disabled", true);
		    $("#left-button").attr("disabled", true);
			if (counter <= 5) {
				ctx.clearRect(0,0,canvas.width,canvas.height);
				$("#counter").text("Please Wait");
				setTimeout(function() {
					leftBound = $.xcolor.average(leftBound, rightBound);
					leftValue = (leftValue + rightValue) / 2.0;
					ctx.fillStyle = $.xcolor.average(leftBound, rightBound);
					ctx.fillRect(0,0,canvas.width,canvas.height);
					if(counter == 5) {
						$("#submit-button").attr("hidden", false);
						$("#right-button").attr("hidden", true);
						$("#left-button").attr("hidden", true);
					}
					if (counter < 5) {
						counter++;
						$("#right-button").attr("disabled", false);
		  		 	 	$("#left-button").attr("disabled", false);
		  		 	}
		  		 	if(counter <= 5) {
		  		 		$("#counter").text("Pass " + counter + "/5");
		  		 	} else {
		  		 		$("#counter").text("Test Complete");
		  		 	}
				}, (1000));
			}
		});
		$("#right-button").click(function() {
		    $("#right-button").attr("disabled", true);
		    $("#left-button").attr("disabled", true);
		    if (counter <= 5) {
				ctx.clearRect(0,0,canvas.width,canvas.height);
				$("#counter").text("Please Wait");
				setTimeout(function() {
					rightBound = $.xcolor.average(leftBound, rightBound);
					rightValue = (leftValue + rightValue) / 2.0;
					ctx.fillStyle = $.xcolor.average(leftBound, rightBound);
					ctx.fillRect(0,0,canvas.width,canvas.height);
					if(counter == 5) {
						$("#submit-button").attr("hidden", false);
						$("#right-button").attr("hidden", true);
						$("#left-button").attr("hidden", true);
					}
					if(counter < 5) {
						counter++;
						$("#right-button").attr("disabled", false);
		    			$("#left-button").attr("disabled", false);
		    		}
		    		if(counter <= 5) {
		    			$("#counter").text("Pass " + counter + "/5");
		    		} else {
		    			$("#counter").text("Test Complete");
		    		}
				}, (1000));
			}
		});
		$("#submit-button").click(function () {
			xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if(this.readyState == 4 && this.status == 200) {
					window.location.href = '/results?leftColor=${leftColor}&rightColor=${rightColor}&score=' + (leftValue + rightValue) / 2 + '';
				}
			};
			xhttp.open("POST", "submit");
			xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
			xhttp.send("{\"leftColor\": " + JSON.stringify("${leftColor}") + ", \"rightColor\": " + JSON.stringify("${rightColor}") + ", \"score\": \"" + JSON.stringify((leftValue + rightValue) / 2) + "\"}");
		});
	</script>
	<footer class="py-3 bg-white">
      <div class="container">
        <p class="m-0 text-center text-black small">Copyright &copy; <a href="https://www.github.com/feliser">feliser</a> 2020</p>
      </div>
    </footer>
  </body>
</html>