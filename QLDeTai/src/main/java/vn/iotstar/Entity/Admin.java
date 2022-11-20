package vn.iotstar.Entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Admin")
public class Admin {
	@Id
	private String id;
	private String name;
	private Date dateofbirth;
	private String email;
	private String status;
	public Admin(String id, String name, Date dateofbirth, String email, String status) {
		super();
		this.id = id;
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.email = email;
		this.status = status;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}