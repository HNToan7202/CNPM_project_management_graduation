package vn.iotstar.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
//@NoArgsConstructor
public class AdminModel {
	
	private Long id;
	private String name;
	private String email;
	private boolean is_active;
	
	private Boolean isEdit = false;

	public AdminModel(Long id, String name, String email, boolean is_active) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.is_active = is_active;
	}

	public AdminModel() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}
	
	
	
	
	
}
