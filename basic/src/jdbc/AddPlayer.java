package jdbc;
import java.io.*;
import java.sql.*;
import java.util.Scanner;
public class AddPlayer {

	public static void main(String[] args) {
		try {
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter player name:");
			String playername=sc.nextLine();
			System.out.println("Enter photo filename:");
			String photofilename=sc.nextLine();
			con.setAutoCommit(false);
			PreparedStatement ps=con.prepareStatement("insert into players values(?,?)");
			File picfile=new File(photofilename);
			FileInputStream fis=new FileInputStream(picfile);
			ps.setString(1,playername);
			ps.setBinaryStream(2,fis,(int)picfile.length());
			ps.executeUpdate();
			con.commit();
			ps.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			}

	}

}
