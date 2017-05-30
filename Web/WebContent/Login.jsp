<%@page import="oracle.jdbc.rowset.OracleCachedRowSet"%>
<%@ page language="java" import="java.sql.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>Login</h2>
	<form action="Login.jsp" method="post">
		Email:<input type="text" name="uname" value="${param.uname }" required>
		<p />
		Password:<Input type="password" name="pass" value="${param.pass}"
			required>
		<p />
		<input type="submit" value="Login">
	</form>
	<a href="Reg.jsp" target="_blank">
		<button>Regiser</button>
	</a>

	<%
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			OracleCachedRowSet crs = new OracleCachedRowSet();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			String user = request.getParameter("uname");
			String pass = request.getParameter("pass");
			crs.setCommand("select * from registeruser where email=? and pass=?");
			crs.setString(1, user);
			crs.setString(2, pass);
			crs.execute();
			int c = crs.size();
			if (c == 1)
				out.println("<h2>You are successfully logged into your account");
			else
				out.println("Please Check your email id and password");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	%>
</body>
</html>