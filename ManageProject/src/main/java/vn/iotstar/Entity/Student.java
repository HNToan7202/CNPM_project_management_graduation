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
@NoArgsConstructor 
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
	private int idproject;
	private Boolean isleader;
	private Boolean is_active;


	

}
