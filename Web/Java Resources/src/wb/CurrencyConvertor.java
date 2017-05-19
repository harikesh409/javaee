package wb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// @WebServlet("/Currency")
public class CurrencyConvertor extends HttpServlet {
	public static double rate=64.98;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String amt=request.getParameter("amount");
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		if(amt!=null) {
			Double amount=Double.parseDouble(amt);
			double usd=amount/rate;
			pw.println("<h1> Converted Value is: "+usd+"</h1>");
		}
		else {
			pw.println("<h3>Enter a valid amount</h3>");
		}
	}

}
