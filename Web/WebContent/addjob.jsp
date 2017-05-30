<!DOCTYPE html>
<html>
<body>
	<jsp:useBean class="beans.JobBean" scope="page" id="job"></jsp:useBean>
	<jsp:setProperty property="*" name="job" />
	<%
		try {
			job.addJob();
			out.println("Successfully added");
		} catch (Exception ex) {
			out.println(ex.getMessage());
		}
	%>
</body>
</html>