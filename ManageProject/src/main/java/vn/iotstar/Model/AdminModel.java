package vn.iotstar.Model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
	
	
	
}
