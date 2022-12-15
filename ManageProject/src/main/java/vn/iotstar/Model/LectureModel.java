
package vn.iotstar.Model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor

@AllArgsConstructor
public class LectureModel {

	private Long id;
	private String name;
	private Date dateofbirth;
	private String address;
	private String image;

	// private Boolean istruongbomon;

	private String email;
	
	private Integer idhoidong;
	private Boolean isactive;

	private Boolean isEdit = false;

}
