package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Update {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			Statement st =con.createStatement();
			int c=st.executeUpdate("update employees set salary=100 where employee_id=120");
			if(c==1)
				System.out.print("Success");
			else
				System.out.println("Failed");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

}
