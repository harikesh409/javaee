package wb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("first servlet");
		request.setAttribute("name","Harikesh");
		RequestDispatcher rd=request.getRequestDispatcher("/second");
		//rd.forward(request, response);
		rd.include(request, response);
		out.println("Again in First Servlet");
		out.close();
	}

}
