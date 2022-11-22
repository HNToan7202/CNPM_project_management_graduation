
package vn.iotstar.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "users")
public class User {
	
	@Id
	private long username;
	
	@Column(name ="password")
	private String password;
	
	@Column(name ="stauts")
	private boolean status;
	
	@ManyToMany
	@JoinTable(name = "user_role",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
	List<Role> roles = new ArrayList<>();
	
    @OneToOne(mappedBy = "user_student", cascade = CascadeType.ALL)
    private Student student;
    
    @OneToOne(mappedBy = "user_lecture", cascade = CascadeType.ALL)
    private Lecture lecture;
    
    @OneToOne(mappedBy = "user_admin", cascade = CascadeType.ALL)
    private Admin admin;
	
	public long getUsername() {
		return username;
	}

	public void setUsername(long username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public User() {
		super();
	}
    
	
}