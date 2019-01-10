
let xhr = new XMLHttpRequest();

xhr.open('GET', '../FillInName',true);

 
 xhr.onreadystatechange = function() {
     
     if (this.readyState === 4 && this.status === 200) {
    	 document.getElementById("namefield").innerHTML =
             this.responseText;
      
}
};

xhr.send();