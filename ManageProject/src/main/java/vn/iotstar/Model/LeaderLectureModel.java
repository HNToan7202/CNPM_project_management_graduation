package vn.iotstar.Model;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import lombok.*;
import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaderLectureModel {
	private int id;
	private String name;
	private Date dateofbirth;
	private String image;
	private MultipartFile imageFile; // lưu hình
	@NotEmpty(message = "mail khong duoc phep de trong")
	@Email(message = "Mail khong hop le")
	private String email;
	private String address;
	private boolean isActive;
	
	private Boolean isEdit = false;

	public LeaderLectureModel(int id, String name, Date dateofbirth, String image,
			@NotEmpty(message = "mail khong duoc phep de trong") @Email(message = "Mail khong hop le") String email,
			String address, boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.image = image;
		this.email = email;
		this.address = address;
		this.isActive = isActive;
	}
	
	
	
}