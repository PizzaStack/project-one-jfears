let xhrpend = new XMLHttpRequest();

xhrpend.open('GET', '../GetPending',true);

xhrpend.onreadystatechange = function(){
	if(this.readyState === 4 && this.status === 200){
		document.getElementById("tblerow").innerHTML=this.responseText;
	}
};

xhrpend.send();