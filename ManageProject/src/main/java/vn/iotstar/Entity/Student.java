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
/* @NoArgsConstructor */
@AllArgsConstructor
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
	private Long id_project;
	private Boolean is_leader;
	private Boolean is_active;


	public Student() {
		super();
	}

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

	public Long getId_project() {
		return id_project;
	}

	public void setId_project(Long id_project) {
		this.id_project = id_project;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	public Boolean getIs_leader() {
		return is_leader;
	}

	public void setIs_leader(Boolean is_leader) {
		this.is_leader = is_leader;
	}

	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "email", insertable = false, updatable = false,
	 * referencedColumnName = "email")
	 * 
	 * @JsonManagedReference private Account account;
	 */

}
