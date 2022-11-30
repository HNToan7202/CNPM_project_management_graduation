package vn.iotstar.Model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouncilModel {
	private Long id;
	
	private int soluongTV;
	
	private int id_project;
	
	private int id_headLecture;
	
	private boolean is_active;
	
	private Boolean isEdit = false;

	public CouncilModel(Long id, int soluongTV, int id_project, int id_headLecture, boolean is_active) {
		super();
		this.id = id;
		this.soluongTV = soluongTV;
		this.id_project = id_project;
		this.id_headLecture = id_headLecture;
		this.is_active = is_active;
	}
	
}
