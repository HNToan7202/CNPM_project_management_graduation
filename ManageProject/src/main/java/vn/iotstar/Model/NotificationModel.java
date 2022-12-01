package vn.iotstar.Model;

import java.sql.Date;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationModel {
	private Long id;
	private String name;
	private Date create_at;
	private Date update_at;
	private String desciption;
	private boolean for_student;
	private boolean is_active;
	
	private Boolean isEdit = false;

	public NotificationModel(Long id, String name, Date create_at, Date update_at, String desciption,
			boolean for_student, boolean is_active) {
		super();
		this.id = id;
		this.name = name;
		this.create_at = create_at;
		this.update_at = update_at;
		this.desciption = desciption;
		this.for_student = for_student;
		this.is_active = is_active;
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

	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	public Date getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(Date update_at) {
		this.update_at = update_at;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public boolean isFor_student() {
		return for_student;
	}

	public void setFor_student(boolean for_student) {
		this.for_student = for_student;
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

	public NotificationModel(Long id, String name, Date create_at, Date update_at, String desciption,
			boolean for_student, boolean is_active, Boolean isEdit) {
		super();
		this.id = id;
		this.name = name;
		this.create_at = create_at;
		this.update_at = update_at;
		this.desciption = desciption;
		this.for_student = for_student;
		this.is_active = is_active;
		this.isEdit = isEdit;
	}

	public NotificationModel() {
		super();
	}


	

}
