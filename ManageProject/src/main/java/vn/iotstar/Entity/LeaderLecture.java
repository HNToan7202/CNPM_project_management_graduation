package vn.iotstar.Entity;

import java.io.Serializable;
import java.sql.Date;


import javax.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "leaderlecture")
public class LeaderLecture  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="name",length = 255, columnDefinition = "nvarchar(255) not null")
	private String name;
	@Column(name="dateofbirth")
	private Date dateofbirth;
	@Column(name="image")
	private String image;
	@Column(name="email")
	private String email;
	@Column(name="address", length = 255, columnDefinition = "nvarchar(255) not null")
	private String address;
	@Column(name="is_active")
	private boolean is_active;
	

}
