package vn.iotstar.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "notification")
public class Notification implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// @Column(name="name",length = 50, columnDefinition = "nvarchar(50) not null")
	private String name;
	// @Column(name="create_at")
	private Date create_at;
	// @Column(name="update_at")
	private Date update_at;

	// @Column(name="desciption",length = 50, columnDefinition = "nvarchar(50) not
	// null")
	private String desciption;
	// @Column(name="for_student")
	private boolean chosv;
	// @Column(name="isactive")
	private boolean is_active;

	private Long idstudent;
	private Long idlecture;
	private boolean student;
}
