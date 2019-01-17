let xhrpendman = new XMLHttpRequest();

xhrpendman.open('GET', '../GetPendingMan',true);

xhrpendman.onreadystatechange = function(){
	if(this.readyState === 4 && this.status === 200){
		var tableman = document.getElementById("requesttableman");
		var jsonarrayman = [];
		jsonarrayman = JSON.parse(this.responseText);
		console.log(jsonarrayman);
		
		for(i in jsonarrayman){
			var json = jsonarrayman[i];
			var row = tableman.insertRow(0);
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);
			var cell5 = row.insertCell(4);
			var cell6 = row.insertCell(5);
			cell1.innerHTML = json.reqid;
			cell2.innerHTML = json.title;
			cell3.innerHTML = json.details;
			cell4.innerHTML = json.status
			cell5.innerHTML = json.rcpid;
			cell6.innerHTML = json.appman;
			
			
		}
	}
};

xhrpendman.send();