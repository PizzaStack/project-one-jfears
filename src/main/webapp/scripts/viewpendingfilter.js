let xhrfilter = new XMLHttpRequest();

document.getElementById("filterbutton").addEventListener(
		"click",
		function() {
			var filterfield = document.getElementById("filterfield").value;

			xhrfilter.open("GET", "../FilterPending" + `?filterfield=${filterfield}`);

			
			xhrfilter.onreadystatechange = function() {
				
				if (this.readyState === 4 && this.status === 200) {

					 var table = document.getElementById("filteredtable");
					 var jsonarray = [];
					 jsonarray = JSON.parse(this.responseText);
					 console.log(jsonarray);
								
					 for(i in jsonarray){
					 var json = jsonarray[i];
					 
					 var row = table.insertRow(0);
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
			}

			xhrfilter.send();
		});
