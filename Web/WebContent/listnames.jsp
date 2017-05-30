<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Session Names</h2>
<%
	Set<String> names=(Set<String>) session.getAttribute("names");
	if(names!=null) {
		for(String n:names)
			out.println(n + " <a href='removename.jsp?name=" + n + "'>Remove</a><p/>");
	}
%>
<p />
<a href="addname.html">Add Name</a>
<a href="clearnames.jsp">Clear Names</a>
</body>
</html>