<%@ page language="java" import="java.sql.*,javax.json.*"
	contentType="text/json; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
	PreparedStatement ps = con
			.prepareStatement("select first_name,salary from employees where employee_id=?");
	ps.setString(1, request.getParameter("empid"));
	ResultSet rs = ps.executeQuery();
	JsonObjectBuilder builder = Json.createObjectBuilder();
	//generate JSON
	if (rs.next()) //employee found
	{
		builder.add("name", rs.getString("first_name"));
		builder.add("salary", rs.getInt("salary"));
	} else
		builder.add("error", "Sorry! Employee Not Found");
	out.println(builder.build().toString());
	rs.close();
	ps.close();
	con.close();
%>