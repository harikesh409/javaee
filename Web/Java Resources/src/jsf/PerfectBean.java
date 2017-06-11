package jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

@ManagedBean
@RequestScoped
public class PerfectBean {
	private int number;
	private String message;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public void check(ActionEvent evt){
		int sum=0;
		for(int i=1;i<=number/2;i++) {
			if(number%i==0) {
				sum+=i;
			}
		}
		if(sum==number)
			message="Perfect number";
		else
			message="Not a perfect number";
	}
}
