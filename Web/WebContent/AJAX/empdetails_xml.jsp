<%@ page import="java.sql.*" language="java"
	contentType="text/xml; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
	String empid = request.getParameter("empid");
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager
			.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
	Statement st = con.createStatement();
	ResultSet rs = st
			.executeQuery("select first_name,salary from employees where employee_id="
					+ empid);
	if (rs.next()) {
		out.println("<employee><name>");
		out.println(rs.getString(1));
		out.println("</name><salary>");
		out.println(rs.getInt(2));
		out.println("</salary></employee>");
	} else
		out.println("<error>Employee ID Not Found</error>");
	rs.close();
	st.close();
	con.close();
%>