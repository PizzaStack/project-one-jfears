let xhrpend = new XMLHttpRequest();

xhrpend.open('GET', '../GetPending',true);

xhrpend.onreadystatechange = function(){
	if(this.readyState === 4 && this.status === 200){
		var table = document.getElementById("requesttable");
		var jsonarray = [];
		jsonarray = JSON.parse(this.responseText);
		
		
		for(i in jsonarray){
			var json = jsonarray[i];
			var row = table.insertRow(0);
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);
			var cell5 = row.insertCell(4);
			cell1.innerHTML = json.reqid;
			cell2.innerHTML = json.title;
			cell3.innerHTML = json.details;
			cell4.innerHTML = json.status
			cell5.innerHTML = json.rcpid;
			
		}
	}
};

xhrpend.send();