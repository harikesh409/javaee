package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class JobsHandler3 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {

		JspWriter out = getJspContext().getOut();
		JspFragment body = this.getJspBody();
		PageContext ctx = (PageContext) this.getJspContext();

		try {
			OracleCachedRowSet crs = new OracleCachedRowSet();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from jobs");
			crs.execute();

			while (crs.next()) {
				ctx.setAttribute("id", crs.getString("job_id"));
				ctx.setAttribute("title", crs.getString("job_title"));
				ctx.setAttribute("min", crs.getInt("min_salary"));
				ctx.setAttribute("max", crs.getInt("max_salary"));

				body.invoke(out); // process body and send result to client
			}

			crs.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}