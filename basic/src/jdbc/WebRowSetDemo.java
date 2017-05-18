package jdbc;
import oracle.jdbc.rowset.*;
import java.io.*;
public class WebRowSetDemo {
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		OracleWebRowSet rs=new OracleWebRowSet();
		rs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		rs.setUsername("hr");
		rs.setPassword("hr");
		rs.setCommand("select * from jobs");
		rs.execute();
		//write to XML
		FileWriter fw=new FileWriter("D:\\tesst.xml");
		rs.writeXml(fw);
		rs.close();
	}
}