package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JobBean {
	private String id, title;

	public void addJob() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try (Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
				PreparedStatement ps = con
						.prepareStatement("insert into jobs values(?,?,null,null)")) {
			ps.setString(1, id);
			ps.setString(2, title);
			ps.executeUpdate();
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
