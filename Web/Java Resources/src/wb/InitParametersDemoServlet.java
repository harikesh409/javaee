package wb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet("/Param")
public class InitParametersDemoServlet extends HttpServlet {
	String msg;
	int counter=0;
	@Override
	public void init(ServletConfig config) throws ServletException {
		msg=config.getInitParameter("Param");

	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		counter++;
		pw.println("<h1>"+msg+"</h1><h3> Displayed for: "+counter+"times</h3>");
	}

}
