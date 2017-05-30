<%@ page language="java" import="java.sql.*,javax.json.*"
	contentType="text/json; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
	javax.sql.rowset.CachedRowSet crs = new oracle.jdbc.rowset.OracleCachedRowSet();
	crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
	crs.setUsername("hr");
	crs.setPassword("hr");
	crs.setCommand("select first_name ||' ' || last_name fullname from employees where job_id=?");
	crs.setString(1, request.getParameter("jobid"));
	crs.execute();
	JsonArrayBuilder emps = Json.createArrayBuilder();
	
	while (crs.next()) {
		JsonObjectBuilder emp = Json.createObjectBuilder();
		emp.add("fullname",crs.getString("fullname"));
		emps.add(emp.build());
	}
	crs.close();
	out.println(emps.build().toString());
%>