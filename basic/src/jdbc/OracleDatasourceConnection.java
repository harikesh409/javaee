package jdbc;
import java.sql.Connection;
import oracle.jdbc.pool.OracleDataSource;
public class OracleDatasourceConnection {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub

			OracleDataSource ods=new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			ods.setUser("hr");
			ods.setPassword("hr");
		try {
			@SuppressWarnings("unused")
			Connection con=ods.getConnection();
			System.out.println("Connected To Oracle using DataSource");
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}