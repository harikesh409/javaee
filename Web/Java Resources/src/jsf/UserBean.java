package jsf;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.Size;

@ManagedBean
public class UserBean {
	private String email, password, confirmPassword, message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Size(min = 4, max = 100, message = "Valid length is 4 to 100 chars")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Size(min = 4, max = 8, message = "Valid length is 4 to 8 chars")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Size(min = 4, max = 8, message = "Valid length is 4 to 8 chars")
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String register() {
		if (!password.equals(confirmPassword)) {
			message = "Passwords do not match!";
			return "register";
		}

		System.out.println("register()");
		return "login";
	}

}