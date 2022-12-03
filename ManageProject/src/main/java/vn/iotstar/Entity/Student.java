package vn.iotstar.Entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
//@NoArgsConstructor 
//@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name = "Student")
public class Student implements Serializable {

	@Id
	private Long mssv;

	private String name;
	private Date dateofbirth;
	private String image;
	private String email;
	private String faculty;
	private int idproject;
	private Boolean isleader;
	private Boolean is_active;
	public Long getMssv() {
		return mssv;
	}
	public void setMssv(Long mssv) {
		this.mssv = mssv;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public int getIdproject() {
		return idproject;
	}
	public void setIdproject(int idproject) {
		this.idproject = idproject;
	}
	public Boolean getIsleader() {
		return isleader;
	}
	public void setIsleader(Boolean isleader) {
		this.isleader = isleader;
	}
	public Boolean getIs_active() {
		return is_active;
	}
	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}
	public Student(Long mssv, String name, Date dateofbirth, String image, String email, String faculty, int idproject,
			Boolean isleader, Boolean is_active) {
		super();
		this.mssv = mssv;
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.image = image;
		this.email = email;
		this.faculty = faculty;
		this.idproject = idproject;
		this.isleader = isleader;
		this.is_active = is_active;
	}
	public Student() {
		super();
	}


	

}
