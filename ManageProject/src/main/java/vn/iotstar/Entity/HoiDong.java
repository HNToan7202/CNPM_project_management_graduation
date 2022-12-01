//package vn.iotstar.Entity;
//
//import java.io.Serializable;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@SuppressWarnings("serial")
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Entity
//@Builder
//@Table
//public class HoiDong implements Serializable {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
//	private int soLuongtv;
//
//	private int id_project;
//	private int id_headLecture;
//	private boolean is_active;
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public int getSoLuongTV() {
//		return soLuongTV;
//	}
//	public void setSoLuongTV(int soLuongTV) {
//		this.soLuongTV = soLuongTV;
//	}
//	public int getId_project() {
//		return id_project;
//	}
//	public void setId_project(int id_project) {
//		this.id_project = id_project;
//	}
//	public int getId_headLecture() {
//		return id_headLecture;
//	}
//	public void setId_headLecture(int id_headLecture) {
//		this.id_headLecture = id_headLecture;
//	}
//	public boolean isIs_active() {
//		return is_active;
//	}
//	public void setIs_active(boolean is_active) {
//		this.is_active = is_active;
//	}
//	
//	
//}
