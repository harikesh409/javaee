package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
public class OracleThinConnection {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			System.out.println("Connected Using thin driver");
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
