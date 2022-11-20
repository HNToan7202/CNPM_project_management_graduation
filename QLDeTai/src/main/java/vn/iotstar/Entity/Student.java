package vn.iotstar.Entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name= "Student")
public class Student {
	@Id
	private int mssv;
	
	private String name;
	private Date dateofbirth;
	private String email;
	private String deparment;
	private boolean id_project;
	private boolean id_leader;
	private String status;
	/**
	 * @return the mssv
	 */
	public int getMssv() {
		return mssv;
	}
	/**
	 * @param mssv the mssv to set
	 */
	public void setMssv(int mssv) {
		this.mssv = mssv;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the dateofbirth
	 */
	public Date getDateofbirth() {
		return dateofbirth;
	}
	/**
	 * @param dateofbirth the dateofbirth to set
	 */
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the deparment
	 */
	public String getDeparment() {
		return deparment;
	}
	/**
	 * @param deparment the deparment to set
	 */
	public void setDeparment(String deparment) {
		this.deparment = deparment;
	}
	/**
	 * @return the id_project
	 */
	public boolean isId_project() {
		return id_project;
	}
	/**
	 * @param id_project the id_project to set
	 */
	public void setId_project(boolean id_project) {
		this.id_project = id_project;
	}
	/**
	 * @return the id_leader
	 */
	public boolean isId_leader() {
		return id_leader;
	}
	/**
	 * @param id_leader the id_leader to set
	 */
	public void setId_leader(boolean id_leader) {
		this.id_leader = id_leader;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
}
