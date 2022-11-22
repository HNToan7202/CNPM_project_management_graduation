package vn.iotstar.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Admin")
public class Admin extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "dateofbirth")
	private Date dateofbirth;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "status")
	private boolean status;

	public Admin(String name, Date dateofbirth, String email, Boolean status) {
		super();
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.email = email;
		this.status = status;
	}

}



