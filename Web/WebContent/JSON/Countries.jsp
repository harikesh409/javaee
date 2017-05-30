<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="javax.json.*" %>
	<%@page import="java.net.URL"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Countries</title>
</head>
<body>
	<%
	try {
		URL resturl = new URL("https://restcountries.eu/rest/v1/all");
		JsonReader reader = Json.createReader(resturl.openStream());

		JsonArray countries = reader.readArray();

		for (int i = 0; i < countries.size(); i++) {
			JsonObject country = countries.getJsonObject(i);
			out.println(country.getString("capital"));

		}
	}
	catch(Exception ex) {
		ex.printStackTrace();
	}
	%>
</body>
</html>