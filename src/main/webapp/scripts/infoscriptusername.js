let xhruser = new XMLHttpRequest();

xhruser.open('GET', '../FillInUsername',true);

 
 xhruser.onreadystatechange = function() {
     
     if (this.readyState === 4 && this.status === 200) {
    	 document.getElementById("usernamefield").innerHTML =
             this.responseText;
      
}
};

xhruser.send();