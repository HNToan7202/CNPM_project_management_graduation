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
	private Long id;
	private String name;
	private Date dateofbirth;
	private String image;
	private MultipartFile imageFile; // lưu hình
	@NotEmpty(message = "mail khong duoc phep de trong")
	@Email(message = "Mail khong hop le")
	private String email;
	private String address;
	private boolean is_active;
	
	private Boolean isEdit = false;

	public LeaderLectureModel(Long id, String name, Date dateofbirth, String image,
			@NotEmpty(message = "mail khong duoc phep de trong") @Email(message = "Mail khong hop le") String email,
			String address, boolean is_active) {
		super();
		this.id = id;
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.image = image;
		this.email = email;
		this.address = address;
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

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public MultipartFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public LeaderLectureModel() {
		super();
	}

	public LeaderLectureModel(Long id, String name, Date dateofbirth, String image, MultipartFile imageFile,
			@NotEmpty(message = "mail khong duoc phep de trong") @Email(message = "Mail khong hop le") String email,
			String address, boolean is_active, Boolean isEdit) {
		super();
		this.id = id;
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.image = image;
		this.imageFile = imageFile;
		this.email = email;
		this.address = address;
		this.is_active = is_active;
		this.isEdit = isEdit;
	}



	
	
	
	
	
}
