package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
public class UpdateResultSet {
	public static void main(String[] args)
	{
		try {
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery("select job_id,job_title,min_salary from jobs");
			rs.last();// goto last row
			//values before change
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			//update min_salary
			rs.updateInt(3,rs.getInt(3)+1000);
			rs.updateRow();//update database
			//values after cahnge
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			}
		catch(Exception ex){
			System.out.println(ex);
		}
	}

}
