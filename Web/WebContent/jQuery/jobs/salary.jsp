<%@page import="oracle.jdbc.rowset.OracleCachedRowSet"%>
<%@page import="javax.sql.rowset.CachedRowSet"%>
<%@ page language="java" import="java.sql.*,javax.json.*"
	contentType="application/json; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	CachedRowSet crs = new OracleCachedRowSet();
	crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
	crs.setUsername("hr");
	crs.setPassword("hr");
	crs.setCommand("select salary from employees where first_name||' ' || last_name=?");
	crs.setString(1, request.getParameter("fullname"));
	crs.execute();
	JsonArrayBuilder sal = Json.createArrayBuilder();
	while (crs.next()) {
		sal.add(crs.getString("salary"));
	}
	crs.close();
	out.println(sal.build().toString());
%>