var vars = {};
var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
    vars[key] = value;
});
$("#left-button").html(vars["leftColor"][0].toUpperCase() + vars["leftColor"].slice(1));
$("#right-button").html(vars["rightColor"][0].toUpperCase() + vars["rightColor"].slice(1));
var canvas = document.getElementById("color-canvas");
var ctx = canvas.getContext("2d");
var leftBound = vars["leftColor"];
var rightBound = vars["rightColor"];
ctx.fillStyle = $.xcolor.average(leftBound, rightBound);
console.log($.xcolor.average(leftBound, rightBound));
ctx.fillRect(0,0,canvas.width,canvas.height);

$("#green-button").click(function() {
	ctx.clearRect(0,0,canvas.width,canvas.height);
	leftBound = $.xcolor.average(leftBound, rightBound);
	ctx.fillStyle = $.xcolor.average(leftBound, rightBound);
	ctx.fillRect(0,0,canvas.width,canvas.height);
	console.log(rightBound);
	console.log($.xcolor.average(leftBound, rightBound));
});
$("#yellow-button").click(function() {
	ctx.clearRect(0,0,canvas.width,canvas.height);
	rightBound = $.xcolor.average(leftBound, rightBound);
	ctx.fillStyle = $.xcolor.average(leftBound, rightBound);
	ctx.fillRect(0,0,canvas.width,canvas.height);
	console.log(leftBound);
	console.log($.xcolor.average(leftBound, rightBound));
});