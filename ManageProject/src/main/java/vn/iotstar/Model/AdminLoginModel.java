package vn.iotstar.Model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


public class AdminLoginModel {

	@NotEmpty(message = "Email không được để trống")
	@Email(message = "Email không hợp lệ")
	private String email;
	@NotEmpty(message = "Mật khẩu không được để trống")
	@Min(value = 6,message = "Password phải từ 6 ký tự trở lên")
	private String password;
	
	private Boolean rememberMe = false;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(Boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
	
	
}
