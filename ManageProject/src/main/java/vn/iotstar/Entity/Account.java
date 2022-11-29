package vn.iotstar.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Account")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String email;
	
	private String password;
	private int role_id;
	private Boolean is_active;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "role_id", nullable = false, referencedColumnName = "id")
	 * 
	 * @JsonBackReference private Role role;
	 * 
	 * @OneToOne(mappedBy = "account")
	 * 
	 * @JsonBackReference private Lecture lecture;
	 * 
	 * @OneToOne(mappedBy = "account")
	 * 
	 * @JsonBackReference private Admin admin;
	 * 
	 * @OneToOne(mappedBy = "account")
	 * 
	 * @JsonBackReference private Student student;
	 * 
	 * @OneToOne(mappedBy = "account")
	 * 
	 * @JsonBackReference private LeaderLecture leaderLecture;
	 */

}