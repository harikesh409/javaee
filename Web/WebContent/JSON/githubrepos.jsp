<%@page import="javax.json.JsonArrayBuilder"%>
<%@page import="javax.json.JsonArray"%>
<%@page import="javax.json.JsonObject"%>
<%@page import="javax.json.Json"%>
<%@page import="javax.json.JsonReader"%>
<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Github Repos</title>
</head>
<body>
	<form action="githubrepos.jsp" method="get"
		style="text-align: center; margin-top: 15%">
		Enter Username: <input type="text" name="uname" value="${param.uname}">
		<input type="submit" value="Fetch">
	</form>

	<%
		try {
			String uname = request.getParameter("uname");
			String repos = "https://api.github.com/users/" + uname
					+ "/repos";
			if (uname == "") {
	%>
	<script>
		window.alert("Enter Username");
	</script>
	<%
		return;
			}
			if (uname == null)
				return;
			System.out.println(repos);
			URL url = new URL(repos);
			JsonReader reader = Json.createReader(url.openStream());
			JsonArray rep = reader.readArray();
			System.out.println(rep.size());
			if (rep.size() < 0)
				out.println("<h2>Check your Username</h2>");
	%><ul style="width: 200px; margin: 0 auto; text-align: left;">
		<%
			for (int i = 0; i < rep.size(); i++) {
					JsonObject obj = rep.getJsonObject(i);
		%>

		<%
			out.println("<li><a href=" + obj.getString("html_url")
							+ " target='_blank'>" + obj.getString("name")
							+ "</li>");
				}
		%>
	</ul>
	<%
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	%>

</body>
</html>