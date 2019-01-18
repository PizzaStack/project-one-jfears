let xhremp = new XMLHttpRequest();

xhremp.open('GET', '../GetEmps',true);

xhremp.onreadystatechange = function(){
	if(this.readyState === 4 && this.status === 200){
		var tableman = document.getElementById("emptable");
		var jsonarrayman = [];
		jsonarrayman = JSON.parse(this.responseText);
		
		
		for(i in jsonarrayman){
			var json = jsonarrayman[i];
			var row = tableman.insertRow(0);
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);
			
			cell1.innerHTML = json.empid;
			cell2.innerHTML = json.empusername;
			cell3.innerHTML = json.empfirstname;
			cell4.innerHTML = json.emplastname;
			
			
			
		}
	}
};

xhremp.send();