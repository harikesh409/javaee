<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Github Userinfo</title>
<script>
	var xmlHttp = new XMLHttpRequest();

	function details() {
		var uname = document.getElementById("uname").value;
		url = "https://api.github.com/users/" + uname;
		xmlHttp.onreadystatechange = doupdate;
		xmlHttp.open("GET", url, true);
		xmlHttp.send();
	}
	function doupdate() {
		var details = document.getElementById("details");
		var error = document.getElementById("error");
		var data = xmlHttp.responseText;
		var detail = eval("(" + data + ")");
		// var detail = JSON.parse(data);
		if (xmlHttp.readyState === 4 && xmlHttp.status === 200) {
			details.innerHTML = detail.name + "<br/>" + detail.location;
			return;
		}/* else {

			error.innerHTML = "ERROR";
		}*/
	}
</script>
</head>
<body>
	<h2>Github Userinfo</h2>
	<form>
		Username: <input type="text" id="uname" size="10" /> <span id="error"
			style="color: red;"></span> <br /></br> <input type="button"
			onclick="details()" value="Get Details" /> <br /> <br/><span
			id="details"></span>
	</form>
</body>
</html>