package tags;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class JobsHandler2 extends SimpleTagSupport {

	private String title;

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public void doTag()throws IOException,JspException {
		JspWriter out=getJspContext().getOut();

		try {
			OracleCachedRowSet crs=new OracleCachedRowSet();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from jobs where upper(job_title) like ?");
			crs.setString(1,"% "+title.toUpperCase()+"%");
			crs.execute();
			int s=crs.size();
			if(s>0) {
			out.println("<h3>List Of Jobs</h3>");
			out.println("<table border='1'><tr><th>Title</th><th>Min Salary </th></tr>");
			while(crs.next()) {
				out.println("<tr><td>" + crs.getString("job_title") + "</td><td>" +
		                 crs.getString("min_salary") + "</td></tr>");
			}
			out.println("</table>");
			}
			else
				out.println("<br/><h2>No such job title</h2>");
			out.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
