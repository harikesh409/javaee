package jdbc;
import java.sql.*;
import java.io.*;
public class ClobDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			con.setAutoCommit(false);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select resume from applicants where id=1");
			rs.next();
			Clob clob=rs.getClob(1);
			InputStream is=clob.getAsciiStream();
			int ch;
			while((ch=is.read())!=-1)
				System.out.println((char)ch);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		

	}

}
