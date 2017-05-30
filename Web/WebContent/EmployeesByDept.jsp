<%@page import="javax.sql.rowset.CachedRowSet"%>
<%@page import="oracle.jdbc.rowset.OracleCachedRowSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees By Dept</title>
</head>
<body>
	<%
		CachedRowSet ocr = new OracleCachedRowSet();
		ocr.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ocr.setUsername("hr");
		ocr.setPassword("hr");
	%>
	<form action="EmployeesByDept.jsp">
		Enter Department Id:<input type="text" name="dept"
			value="${param.dept}" />
		<center>OR</center>
		<br /> <select name="job_id">

			<option value="AC_ACCOUNT">AC_ACCOUNT</option>
			<option value="AC_MGR">AC_MGR</option>
			<option value="AD_ASST">AD_ASST</option>
			<option value="AD_PRES">AD_PRES</option>
			<option value="AD_VP">AD_VP</option>
			<option value="FI_ACCOUNT">FI_ACCOUNT</option>
			<option value="FI_MGR">FI_MGR</option>
			<option value="HR_REP">HR_REP</option>
			<option value="IT_PROG">T_PROG</option>
			<option value="MK_MAN">MK_MAN</option>
			<option value="MK_REP">MK_REP</option>
			<option value="PR_REP">PR_REP</option>
			<option value="PU_CLERK">PU_CLERK</option>
			<option value="PU_MAN">PU_MAN</option>
			<option value="SA_MAN">SA_MAN</option>
			<option value="SA_REP">SA_REP</option>
			<option value="SH_CLERK">SH_CLERK</option>
			<option value="ST_CLERK">ST_CLERK</option>
			<option value="ST_MAN">ST_MAN</option>
		</select> <input type="submit" value="Get Employees" />

	</form>
	<%
	try {
		String deptid = request.getParameter("dept");
		String vid = request.getParameter("job_id");
		if (deptid == null || deptid == "") {
			ocr.setCommand("SELECT * FROM EMPLOYEES WHERE JOB_ID = ?");
			ocr.setString(1, vid);
			ocr.execute();
			return;
		}

		ocr.setCommand("select * from employees where department_id=?");
		ocr.setString(1, deptid);
		ocr.execute();
		int id = Integer.parseInt(deptid);
		if (id > 110 || id < 10 || id % 10 != 0) {
	%>
	<br />
	<b>Enter a valid Department ID</b>
	<%
		return;
		}
	%>
	<p />
	<table style="width: 100%" border="1">
		<tr>
			<th>Name</th>
			<th>Job</th>
			<th>Salary</th>
		</tr>
		<%
			while (ocr.next()) {
		%>
		<tr>
			<td><%=ocr.getString("first_name")%> <%=ocr.getString("last_name")%></td>
			<td><%=ocr.getString("job_id")%></td>
			<td><%=ocr.getString("salary")%></td>
		</tr>
		<%
			}
	}
	catch(Exception ex) {
		ex.printStackTrace();
	}
		%>
	</table>
</body>
</html>