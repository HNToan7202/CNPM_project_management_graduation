package vn.iotstar.Entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Student extends User {
	
	
	@Id
	private Long mssv;

	@Column(name = "name")
	private String name;

	@Column(name = "dateofbirth")
	private Date dateofbirth;

	@Column(name = "email")
	private String email;

	@Column(name = "deparment")
	private String deparment;

	@Column(name = "id_project")
	private boolean id_project;

	@Column(name = "id_leader")
	private boolean id_leader;

	@Column(name = "status")
	private String status;
	

}
