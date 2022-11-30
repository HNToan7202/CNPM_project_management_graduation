package vn.iotstar.Model;

import java.sql.Date;

public class TimeResgiterModel {
	
	public TimeResgiterModel() {
		super();
	}
	private long id;

	private Date create_at;
	private Date finish_at;
	private Boolean isEdit = false;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreate_at() {
		return create_at;
	}
	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}
	public Date getFinish_at() {
		return finish_at;
	}
	public void setFinish_at(Date finish_at) {
		this.finish_at = finish_at;
	}
	public Boolean getIsEdit() {
		return isEdit;
	}
	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}
	public TimeResgiterModel(Date create_at, Date finish_at) {
		super();
		this.create_at = create_at;
		this.finish_at = finish_at;
	}
	
}
