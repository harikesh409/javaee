package jdbc;
/* Program to Display Employes with id<=110 from employees table */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class EmployeeList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select employee_id,first_name from employees where employee_id<=110");
			while(rs.next()){
				System.out.println(rs.getInt(1)+"-"+rs.getString("first_name"));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
