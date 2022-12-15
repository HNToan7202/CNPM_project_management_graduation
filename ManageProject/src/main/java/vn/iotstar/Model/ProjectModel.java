package vn.iotstar.Model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class ProjectModel {

	private Long id;

	private String name;
	private String desciption;
	private String muctieu;
	private String yeucau;
	private int soluongsv;
	private int slsv;
	private Boolean isfaculty;
	private String faculty;
	private String nienkhoa;
	private float point;
	private int idtimeproject;
	private Date create_at;
	private Date update_at;
	private boolean is_active;
	private Long idlecture;

//	public Long getId_lecture() {
//		return id_lecture;
//	}
//	public void setId_lecture(Long id_lecture) {
//		this.id_lecture = id_lecture;
//	}
	private Boolean IsEdit = false;

}
