function logout() {
	var xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){};
	
	xhttp.open("GET", "LogOut");
	xhttp.send();
};
