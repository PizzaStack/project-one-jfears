let xhrres = new XMLHttpRequest();

xhrres.open('GET','../GetResolved',true);

xhrres.onreadystatechange = function(){
	if(this.readyState === 4 && this.status === 200){
		var array = [];
		array = JSON.parse(this.responseText);
		var table = document.getElementById("resolvedtable")
		
		for(i in array){
			var json = array[i];
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
}

xhrres.send();