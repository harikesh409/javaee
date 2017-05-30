<%@page import="oracle.jdbc.rowset.OracleCachedRowSet"%>
<%@page import="javax.sql.rowset.CachedRowSet"%>
<%@ page import="javax.json.*" contentType="application/json" %>
<%
	CachedRowSet crs=new OracleCachedRowSet();
	crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
	crs.setUsername("hr");
	crs.setPassword("hr");
	crs.setCommand("select * from jobs");
	crs.execute();
	JsonArrayBuilder jobs = Json.createArrayBuilder();
	while(crs.next()) {
		JsonObjectBuilder job=Json.createObjectBuilder();
		job.add("id",crs.getString("job_id"));
		job.add("title",crs.getString("job_title"));
		jobs.add(job.build());
	}
	crs.close();
	out.println(jobs.build().toString());
%>