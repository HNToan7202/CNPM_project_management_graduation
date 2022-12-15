
package vn.iotstar.Model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

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
	private MultipartFile imageFile;

	// private Boolean istruongbomon;

	private String email;

	private int idhoidong;

	private boolean isactive;

	private Boolean isEdit = false;



}
