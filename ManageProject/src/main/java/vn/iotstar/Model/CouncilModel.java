package vn.iotstar.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
//@NoArgsConstructor
public class CouncilModel {
	
	private Long id;

	private int soluongtv;

	private int idproject;

	private int idheadlecture;

	private boolean isactive;
	
	private Boolean isEdit = false;

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

	public int getIdproject() {
		return idproject;
	}

	public void setIdproject(int idproject) {
		this.idproject = idproject;
	}

	public int getIdheadlecture() {
		return idheadlecture;
	}

	public void setIdheadlecture(int idheadlecture) {
		this.idheadlecture = idheadlecture;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}

	public CouncilModel(Long id, int soluongtv, int idproject, int idheadlecture, boolean isactive) {
		super();
		this.id = id;
		this.soluongtv = soluongtv;
		this.idproject = idproject;
		this.idheadlecture = idheadlecture;
		this.isactive = isactive;
	}

	public CouncilModel() {
		super();
	}

}
