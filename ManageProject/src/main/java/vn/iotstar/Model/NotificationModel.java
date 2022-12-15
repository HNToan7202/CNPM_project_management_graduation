package vn.iotstar.Model;

import java.sql.Date;

import lombok.Data;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class NotificationModel {
	private Long id;
	private String name;
	private Date create_at;
	private Date update_at;
	private String desciption;
	private boolean chosv;
	private boolean is_active;
	private Long idstudent;
	private Long idlecture;

	private Boolean isEdit = false;

}
