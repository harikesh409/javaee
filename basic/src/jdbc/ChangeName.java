package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class ChangeName {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			PreparedStatement ps=con.prepareStatement("update employees set first_name='john' where employee_id='100'");
			PreparedStatement ps1=con.prepareStatement("update employees set first_name=? where employee_id=?");
			ps1.setString(1,"SMITH");
			ps1.setInt(2, 101);
			int rows1=ps.executeUpdate();
			int rows2=ps1.executeUpdate();
			if(rows1==1 && rows2==1)
				System.out.println("Both Updations are Successful");
			else
				System.out.println("Updation failed");
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

}
