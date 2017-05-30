<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    Set<String> names=(Set<String>) session.getAttribute("names");
    if(names!=null) {
    	names.clear();
    }
    response.sendRedirect("listnames.jsp");
    %>