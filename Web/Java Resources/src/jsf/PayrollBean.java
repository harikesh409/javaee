package jsf;

import javax.faces.bean.ManagedBean;
import javax.sql.RowSet;
import oracle.jdbc.rowset.OracleCachedRowSet;

@ManagedBean
public class PayrollBean {
	private String jobid;
	private RowSet employees;

	public RowSet getEmployees() {
		return employees;
	}

	public void setEmployees(RowSet employees) {
		this.employees = employees;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public String retrieveEmployees() {
		System.out.println(jobid);
		try {
			employees = new OracleCachedRowSet();
			employees.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			employees.setUsername("hr");
			employees.setPassword("hr");
			employees.setCommand("select * from employees where job_id = ?");
			employees.setString(1, jobid);
			employees.execute();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}

	public RowSet getJobs() {
		try {
			OracleCachedRowSet crs = new OracleCachedRowSet();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from jobs");
			crs.execute();
			return crs;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

}