$(document).ready(function(){
	retrieveSavedCoords();

	document.getElementById("dots").addEventListener('click', function(evt){
			var x = evt.layerX;
			var y = evt.layerY;
			console.log("("+x+","+y+")");
			var ctx = this.getContext("2d");
			var xhttp = new XMLHttpRequest();
  			xhttp.onreadystatechange = function() {
    			if (xhttp.readyState == 4 && xhttp.status == 200) {
     				console.log("Coordinates sent");
     				drawMethod(ctx, x, y);
    			}else if(xhttp.status >= 400){
    				var msg = document.getElementById("message")
    				msg.style.visibility = "visible";
    			}
  			};
  			xhttp.open("GET", "/addCoordinate/"+x+"/"+y, true);
  			xhttp.send();
		});
});

var retrieveSavedCoords = function(){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		console.log(xhttp.readyState);
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			var resp = xhttp.responseText;
			var coords = JSON.parse(resp);
			for(var i in coords){
				var coord = coords[i];
				var x = coord.x;
				var y = coord.y;
				var ctx = document.getElementById("dots").getContext("2d");
				drawMethod(ctx, x, y);

			}
		}else if(xhttp.status >= 400){
			var msg = document.getElementById("message")
    		msg.style.visibility = "visible";
    	}
  	};
  	xhttp.open("GET", "/getSavedCoordinates", true);
	xhttp.send();	
}

var drawMethod = function(ctx, x, y){
	drawCircle(ctx, x, y);
	//drawPixel(ctx, x, y);
	//drawCat(ctx, x, y);
}

var drawPixel = function(ctx, x, y){
	ctx.beginPath();
	ctx.arc(x,y,1,0,2*Math.PI);
	ctx.stroke();
}

var drawCircle = function(ctx, x, y){	
	ctx.beginPath();
	ctx.arc(x,y,10,0,2*Math.PI);
	ctx.fillStyle = getRandomColor();
	ctx.fill();
}

var drawCat = function(ctx, x, y){
	var img = document.getElementById("cat");
    ctx.drawImage(img, x, y, 40, 40);
}

var getRandomColor = function(){
    var letters = '0123456789ABCDEF'.split('');
    var color = '#';
    for (var i = 0; i < 6; i++ ) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}