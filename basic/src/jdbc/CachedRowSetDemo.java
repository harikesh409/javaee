package jdbc;
import javax.sql.rowset.CachedRowSet;
import oracle.jdbc.rowset.OracleCachedRowSet;
public class CachedRowSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		CachedRowSet crs=new OracleCachedRowSet();
		crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		crs.setUsername("hr");
		crs.setPassword("hr");
		crs.setCommand("select * from jobs");
		crs.execute();
		System.out.println("Before changing:");
		while(crs.next()) {
			System.out.println(crs.getString(2)+":"+crs.getInt(3));
		}
		crs.absolute(1);
		crs.updateInt(3,crs.getInt(3)+1000);
		crs.updateRow();//updating the changes locally
		crs.beforeFirst();//to move the pointer to befor first so that during next it goes to the first element
		System.out.println("---------------------------------------------------------------------");
		System.out.println("After Changing:");
		while(crs.next())
			System.out.println(crs.getString(2)+":"+crs.getInt(3));
		crs.acceptChanges();//writing the changes to the database
		

	}

}
