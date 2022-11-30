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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSoluongTV() {
		return soluongTV;
	}

	public void setSoluongTV(int soluongTV) {
		this.soluongTV = soluongTV;
	}

	public int getId_project() {
		return id_project;
	}

	public void setId_project(int id_project) {
		this.id_project = id_project;
	}

	public int getId_headLecture() {
		return id_headLecture;
	}

	public void setId_headLecture(int id_headLecture) {
		this.id_headLecture = id_headLecture;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}

	public CouncilModel() {
		super();
	}


	
}
