package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
public class OracleODBCConnection {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("unused")
			Connection con=DriverManager.getConnection("jdbc:odbc:oraclejava","hr","hr");
			System.out.println("Conected using ODBC Driver");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
