package jsf;

import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HelloBean {
	public String getMessage() {
		return "Hello World From Mojarra";
	}

	public String getToday() {
		return new Date().toString();
	}

}
