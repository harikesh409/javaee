package jdbc;
import java.sql.SQLException;
import javax.sql.RowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.Predicate;
import oracle.jdbc.rowset.OracleFilteredRowSet;
public class FilteredRowSetDemo {
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		FilteredRowSet rs=new OracleFilteredRowSet();
		rs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		rs.setUsername("hr");
		rs.setPassword("hr");
		rs.setCommand("select * from jobs");
		rs.execute();
		System.out.println("Jobs with MinSalary > 10000");
		rs.setFilter(new MinSalaryPredicate());
		while(rs.next())
			System.out.println(rs.getString("job_title")+":"+rs.getString("min_salary"));
		System.out.println("Jobs with length(title) >15");
		rs.setFilter(new TitlePredicate());
		rs.execute();
		while(rs.next())
			System.out.println(rs.getString("job_title")+":"+rs.getString(3));
		rs.close();
	}
}
class MinSalaryPredicate implements Predicate {
	@Override
	public boolean evaluate(Object o,int i)throws SQLException {
		return true;
		
	}
	@Override
	public boolean evaluate(Object o,String st)throws SQLException {
		return true;
	}
	@Override
	public boolean evaluate(RowSet rs) {
		try {
			Integer minsal=rs.getInt(3);
			if(minsal>10000)
				return true;
			else
				return false;
		}
		catch (Exception ex) {
			return false;
		}
	}	
}
class TitlePredicate implements Predicate {
	@Override
	public boolean evaluate(Object o,int i)throws SQLException {
		return true;
		
	}
	@Override
	public boolean evaluate(Object o,String st)throws SQLException {
		return true;
	}
	@Override
	public boolean evaluate(RowSet rs) {
		try {
			String title=rs.getString(2);
			if(title.length()>15)
				return true;
			else
				return false;
		}
		catch (Exception ex) {
			return false;
		}
	}	
}
