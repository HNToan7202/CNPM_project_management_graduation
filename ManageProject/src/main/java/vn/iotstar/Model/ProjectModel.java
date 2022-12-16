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
	private Long is_active;
	private Integer idlecture;

	private Boolean IsEdit = false;

}
