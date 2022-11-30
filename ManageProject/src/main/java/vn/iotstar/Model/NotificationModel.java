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
	
	

}
