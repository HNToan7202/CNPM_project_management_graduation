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

@NoArgsConstructor
@AllArgsConstructor

@Data
@Entity
@Builder
@Table(name = "Lecture")
public class Lecture implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private String name;
	private Date dateofbirth;
	private String address;
	private String image;

	private String email;
	private Integer idhoidong;
	private Boolean isactive;

}
