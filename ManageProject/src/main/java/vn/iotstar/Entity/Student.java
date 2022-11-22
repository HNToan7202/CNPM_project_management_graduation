package vn.iotstar.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name = "Student")
public class Student  {
	
	

	@Id
	private Long mssv;

	@Column(name = "name")
	private String name;

	@Column(name = "dateofbirth")
	private Date dateofbirth;


	@Column(name = "image")
	private String image;

	
	@Column(name = "email")
	private String email;

	@Column(name = "deparment")
	private String deparment;

	@Column(name = "id_project")
	private Long id_project;

	@Column(name = "id_leader")
	private Long id_leader;

	@Column(name = "status")
	private String status;

	public Student(Long mssv, String name, Date dateofbirth, String image, String email, String deparment,
			Long id_project, Long id_leader, String status) {
		super();
		this.mssv = mssv;
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.image = image;
		this.email = email;
		this.deparment = deparment;
		this.id_project = id_project;
		this.id_leader = id_leader;
		this.status = status;
	}

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

	public String getDeparment() {
		return deparment;
	}

	public void setDeparment(String deparment) {
		this.deparment = deparment;
	}

	public Long getId_project() {
		return id_project;
	}

	public void setId_project(Long id_project) {
		this.id_project = id_project;
	}

	public Long getId_leader() {
		return id_leader;
	}

	public void setId_leader(Long id_leader) {
		this.id_leader = id_leader;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user_student;
	 
}
