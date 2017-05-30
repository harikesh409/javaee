package wb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Reg")
public class Reg extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			String user = request.getParameter("uname");
			String pass = request.getParameter("pass1");
			String email = request.getParameter("email");
			String coun = request.getParameter("country");
			String p1 = request.getParameter("pass1");
			String p2 = request.getParameter("pass2");
			if (p2.equals(p1)) {
				PreparedStatement ps = con
						.prepareStatement("insert into registeruser values(?,?,?,?)");
				ps.setString(1, user);
				ps.setString(2, pass);
				ps.setString(3, email);
				ps.setString(4, coun);
				int i = ps.executeUpdate();
				if (i == 1)
					out.println("<h3>You are Successfully registered</h3>");
				else
					out.println("<h3>Sorry due to some problem you did not register </h3>");
				
			} else {
				out.println("<script>");
				out.println("window.alert('Reneter password');");
				out.println("</script>");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
