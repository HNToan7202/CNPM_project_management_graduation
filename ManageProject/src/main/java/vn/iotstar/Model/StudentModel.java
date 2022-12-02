package vn.iotstar.Model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentModel {
	private Long mssv;
	private String name;
	private Date dateofbirth;
	private String image;
	private String email;
	private String faculty;
	private int idproject;
	private Boolean isleader;
	private Boolean is_active;
	private MultipartFile imageFile;
	private Boolean isEdit = false;

	

}
