package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
public class OracleOCIConnection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:oci8:@","hr","hr");
			System.out.println("Connected using OCI driver");
			con.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
