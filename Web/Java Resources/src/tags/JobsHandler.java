package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class JobsHandler extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException,IOException {
		
		JspWriter out=getJspContext().getOut();
		
		try {
			OracleCachedRowSet crs=new OracleCachedRowSet();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from jobs");
			crs.execute();
			int s=crs.size();
			if(s>0) {
			out.println("<h3>List of jobs</h3>");
			out.println("<table border='1'><tr><th>Name</th><th>Min Salary</th></tr>");
			while(crs.next()) {
				out.println("<tr><td>" + crs.getString("job_title") + "</td><td>" +
		                 crs.getString("min_salary") + "</td></tr>");
			}
			out.println("</table>");
			}
			else
				out.println("<br/><h2>No such Job Title</h2>");
			crs.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
