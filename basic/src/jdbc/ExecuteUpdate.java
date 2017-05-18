package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class ExecuteUpdate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
				Statement st=con.createStatement()){
			int count=st.executeUpdate("update employees set salary=500 where employee_id=120");
			if(count==1){
				System.out.println("Updation is successful");
			}
			else
				System.out.println("Updation is unseccessful");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
