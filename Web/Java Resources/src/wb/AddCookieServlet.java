package wb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addcookie")
public class AddCookieServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("cname");
		String value=request.getParameter("cvalue");
		String durable=request.getParameter("durable");
		Cookie c=new Cookie(name,value);
		if(durable!=null) {
			c.setMaxAge(7*24*60*60);
		}
		response.addCookie(c);
		pw.print("<h3>Cookie is created</h3>");
		pw.close();
	}
}
