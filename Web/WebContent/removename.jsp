<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<% 
	String name=request.getParameter("name");
	Set<String> names=(Set<String>) session.getAttribute("names");
	if(names!=null) {
		names.remove(name);
	}
	response.sendRedirect("listnames.jsp");
	%>