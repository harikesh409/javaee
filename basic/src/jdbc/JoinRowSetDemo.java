package jdbc;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import oracle.jdbc.rowset.OracleCachedRowSet;
import oracle.jdbc.rowset.OracleJoinRowSet;
public class JoinRowSetDemo {

	public static void main(String[] args)throws Exception {
		CachedRowSet crs1=new OracleCachedRowSet();
		crs1.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		crs1.setUsername("hr");
		crs1.setPassword("hr");
		crs1.setCommand("select job_id,job_title from jobs");
		crs1.execute();
		CachedRowSet crs2=new OracleCachedRowSet();
		crs2.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		crs2.setUsername("hr");
		crs2.setPassword("hr");
		crs2.setCommand("select job_id,first_name,salary from employees");
		crs2.execute();
		JoinRowSet jrs=new OracleJoinRowSet();
		jrs.addRowSet(crs1,"job_id");
		jrs.addRowSet(crs2,"job_id");
		while(jrs.next()){
			if(jrs.getInt(4)>10000)
				System.out.printf("Employee %s is %s \n",jrs.getString(3),jrs.getString(2));
		}
		
		
	}

}
