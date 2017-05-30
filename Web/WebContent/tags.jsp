<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.a2z-blog.tk/tags" prefix="st" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tags</title>
</head>
<body>

<input list="jobs">
<datalist id="jobs">
<st:jobs3>
<option value= "${id}">
</st:jobs3>
</datalist>
<ol>
 <st:jobs3>
     <li style="color:red">${title}, ${min} </li> 
 </st:jobs3>
</ol>
<st:jobs/>
<st:jobs2 title="ma"/>
</body>
</html>