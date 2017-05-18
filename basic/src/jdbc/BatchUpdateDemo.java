package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.BatchUpdateException;
public class BatchUpdateDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			con.setAutoCommit(false);
			Statement stmt=con.createStatement();
			try {
				stmt.addBatch("update employees set salary=salary+2000 where salary>10000");
				stmt.addBatch("update employees set salary=salary+1000 where salary<10000");
				int uc[]=stmt.executeBatch();//execution of batch
				con.commit();
				for(int i=0;i<uc.length;i++)
					System.out.println(i+":"+uc[i]);
			}
			catch(BatchUpdateException ex) {
				System.out.println("Batch Update Exception: "+ex.getMessage());
				con.rollback();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
