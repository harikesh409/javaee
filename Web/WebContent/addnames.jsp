<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    String name=request.getParameter("name");
    Set<String> names = (Set<String>) session.getAttribute("names");
    if(names==null) {
    	names=new TreeSet<String>();
    	session.setAttribute("names", names);
    }
    names.add(name);
    response.sendRedirect("listnames.jsp");
    %>