package wb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Details")
public class Details extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("empid");
		int eid=Integer.parseInt(id);
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		Connection con=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select first_name,salary,job_id from employees where employee_id="+eid);
			boolean ver;
			while(ver=rs.next()){
				pw.println("Details with employee id:"+eid+" are:<br>");
				pw.println("Name="+rs.getString("first_name")+"<br>");
				pw.println("Salary="+rs.getString("salary")+"<br>");
				pw.println("Job="+rs.getString("job_id")+"<br>");
				}
			if(ver==true)
				pw.println("Sorry! Employee id Not Found");

		}
		catch(Exception ex) {
			System.out.println(ex);
			pw.println("Unable to retrive details due to some error");
		}
		finally {
			try {
				con.close();
			}
			catch(Exception ex){
				
			}
		}
	}

}
