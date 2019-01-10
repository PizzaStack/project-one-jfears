let xhrpass = new XMLHttpRequest();

xhrpass.open('GET', '../FillInPassword',true);

 
 xhrpass.onreadystatechange = function() {
     
     if (this.readyState === 4 && this.status === 200) {
    	 document.getElementById("passwordfield").innerHTML =
             this.responseText;
      
}
};

xhrpass.send();