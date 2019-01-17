

document.getElementById("editinfo").addEventListener("click", function editInfo(){
	document.getElementById("editform").innerHTML = "<input name='newfirstname' type='text' placeholder='First name'><input name='newlastname' type='text' placeholder='Last name'><input name='newusername' type='text' placeholder='Username'><input name='newpass' type='text' placeholder='Password'><button type=submit>Submit</button>";
	console.log("clicked");
});