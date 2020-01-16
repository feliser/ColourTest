
var leftMenu = document.getElementById("colormenu-left");
var rightMenu = document.getElementById("colormenu-right");
var leftColor = "Green";
var rightColor = "Yellow";

$(document).ready(function() {
	leftMenu.onchange = function() {
		$('#right' + leftColor).prop("disabled", false);
 		document.getElementById("canvas-gradient").style.backgroundImage="linear-gradient(90deg,"+leftMenu.options[leftMenu.selectedIndex].value+","+rightMenu.options[rightMenu.selectedIndex].value;
 		leftColor = leftMenu.options[leftMenu.selectedIndex].value;
 		$('#right' + leftColor).attr("disabled", "disabled");
	}
	rightMenu.onchange = function() {
		$('#left' + rightColor).prop("disabled", false);
 		document.getElementById("canvas-gradient").style.backgroundImage="linear-gradient(90deg,"+leftMenu.options[leftMenu.selectedIndex].value+","+rightMenu.options[rightMenu.selectedIndex].value;
 		rightColor = rightMenu.options[rightMenu.selectedIndex].value;
 		$('#left' + rightColor).attr("disabled", "disabled");
	}

	$('#start-button').click(function() {
       window.location.href = window.location.href + "test?leftColor=" + leftColor + "&rightColor=" + rightColor; 
	});
}); 