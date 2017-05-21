<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>

</head>
<body>
	<h1>Register</h1>
	<form action="Reg.jsp" method="post">
		Name: <input type="text" name="uname" value="${param.uname}" required><small>*</small>
		<p />
		Email: <input type="email" name="email" value="${param.email}"
			required><small>*</small>
		<p />
		Password: <input type="password" name="pass1" id="p1" required><small>*</small>
		<p />
		Retype Password: <input type="password" name="pass2" id="p2"
			required="required"><small>*</small>
		<p />
		Country: <input type="text" name="country" value="${param.country}">
		<p />
		<input type="submit"  value="Create">
	</form>
	<%
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		String user = request.getParameter("uname");
		String pass = request.getParameter("pass1");
		String email = request.getParameter("email");
		String coun = request.getParameter("country");
		String p1 = request.getParameter("pass1");
		String p2 = request.getParameter("pass2");
		if (p2.equals(p1)) {
			PreparedStatement ps = con
					.prepareStatement("insert into registeruser values(?,?,?,?)");
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.setString(3, email);
			ps.setString(4, coun);
			int i = ps.executeUpdate();
			if (i == 1)
				out.println("<h3>You are Successfully registered</h3>");
			else
				out.println("<h3>Sorry due to some problem you did not register </h3>");
			
		} else { %>
			<script>			
			window.alert('Reneter password');
			document.getElementById("p1").style.borderColor='#E34234';
			document.getElementById("p2").style.borderColor='#E34234';
			</script>
		<%
		}
	} catch (Exception ex) {
		System.out.println(ex);
	}
	%>
</body>
</html>
