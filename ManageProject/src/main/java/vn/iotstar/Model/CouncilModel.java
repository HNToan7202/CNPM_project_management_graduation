package vn.iotstar.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouncilModel {
	private Long id;
	
	private int soluongtv;
	
	private int id_project;
	
	private int id_headlecture;
	
	private boolean is_active;
	
	private Boolean isEdit = false;

	public CouncilModel(Long id, int soluongTV, int id_project, int id_headLecture, boolean is_active) {
		super();
		this.id = id;
		this.soluongtv = soluongTV;
		this.id_project = id_project;
		this.id_headlecture = id_headLecture;
		this.is_active = is_active;
	}
	
	public CouncilModel() {
		super();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSoluongtv() {
		return soluongtv;
	}

	public void setSoluongtv(int soluongtv) {
		this.soluongtv = soluongtv;
	}

	public int getId_project() {
		return id_project;
	}

	public void setId_project(int id_project) {
		this.id_project = id_project;
	}

	public int getId_headlecture() {
		return id_headlecture;
	}

	public void setId_headlecture(int id_headlecture) {
		this.id_headlecture = id_headlecture;
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
	
	
	
}
