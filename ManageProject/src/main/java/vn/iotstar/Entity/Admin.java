package vn.iotstar.Entity;

import javax.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="name",length = 100, columnDefinition = "nvarchar(100) not null")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "is_active")
	private boolean is_active;
	

}



