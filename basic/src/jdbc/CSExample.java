package jdbc;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.DriverManager;
public class CSExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			CallableStatement cs=con.prepareCall("{call UpdateSalary(?,?)}");
			cs.setInt(1, 100);// setting employee_id
			cs.setInt(2,65000);//setting the new salary
			boolean c=cs.execute();//executing update command
			if(c==false)
				System.out.println("Success");
			else
				System.out.println("Failed");
				
			}
		catch (Exception ex){
			System.out.println("Error:"+ex);
		}

	}

}
