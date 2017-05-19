package wb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
name="ParamDemo2",
urlPatterns=("/Param2"),
initParams= {
@WebInitParam(name="p1", value="hari"),
@WebInitParam(name="p2",value="kesh")
})
public class ParamDemo2 extends HttpServlet {
	String m1,m2;
	@Override
	public void init(ServletConfig config)throws ServletException {
		m1=config.getInitParameter("p1");
		m2=config.getInitParameter("p2");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println(m1+m2);
		
	}

}
