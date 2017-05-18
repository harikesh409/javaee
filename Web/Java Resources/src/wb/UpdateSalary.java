package wb;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateSal")
public class UpdateSalary extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empid=request.getParameter("empid");
		String sal=request.getParameter("sal");
		int eid=Integer.parseInt(empid);
		int newsal=Integer.parseInt(sal);
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			PreparedStatement ps=con.prepareStatement("update employees set salary=? where employee_id=?");
			ps.setInt(1,newsal);
			ps.setInt(2,eid);
			int c=ps.executeUpdate();
			if(c==1)
				pw.println("Successfully Updated");
			else
				pw.println("Id not found");			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			pw.println("Unable to update due to some error");
		}
		finally {
			try {
			con.close();
			}
			catch(Exception ex) {				
			}
		}
	}
}
