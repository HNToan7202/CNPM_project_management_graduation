package vn.iotstar.Entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name = "Projects")
@NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p")
public class Project implements Serializable {

	@Id
	@Column(name = "id", columnDefinition = "nvarchar(20)")
	private String id;

	private String name;
	private String desciption;
	private String mucTieu;
	private String yeuCau;
	private int soLuongSV;
	private boolean is_Faculty;
	private String Faculty;
	private String nienKhoa;
	private float point;
	private int id_TimeProject;
	private Date create_at;
	private Date update_at;
	private boolean is_active;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public String getMucTieu() {
		return mucTieu;
	}

	public void setMucTieu(String mucTieu) {
		this.mucTieu = mucTieu;
	}

	public String getYeuCau() {
		return yeuCau;
	}

	public void setYeuCau(String yeuCau) {
		this.yeuCau = yeuCau;
	}

	public int getSoLuongSV() {
		return soLuongSV;
	}

	public void setSoLuongSV(int soLuongSV) {
		this.soLuongSV = soLuongSV;
	}

	public boolean isIs_Faculty() {
		return is_Faculty;
	}

	public void setIs_Faculty(boolean is_Faculty) {
		this.is_Faculty = is_Faculty;
	}

	public String getFaculty() {
		return Faculty;
	}

	public void setFaculty(String faculty) {
		Faculty = faculty;
	}

	public String getNienKhoa() {
		return nienKhoa;
	}

	public void setNienKhoa(String nienKhoa) {
		this.nienKhoa = nienKhoa;
	}

	public float getPoint() {
		return point;
	}

	public void setPoint(float point) {
		this.point = point;
	}

	public int getId_TimeProject() {
		return id_TimeProject;
	}

	public void setId_TimeProject(int id_TimeProject) {
		this.id_TimeProject = id_TimeProject;
	}

	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	public Date getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(Date update_at) {
		this.update_at = update_at;
	}

}
