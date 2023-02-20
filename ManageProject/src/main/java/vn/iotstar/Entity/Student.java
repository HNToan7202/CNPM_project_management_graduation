package vn.iotstar.Entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

@Data
@Entity
@Builder

@Table(name = "Student")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer mssv;
	private String name;
	private Date dateofbirth;
	private String image;
	private String email;
	private String faculty;
	private Long idproject;
	private Boolean isleader;
	private Boolean is_active;

	private Long waitproject;// thuộc tính thể hiện sinh viên đăng ký đề tài: // 1: đã được duyệt vào đề tài:
								// 0 Chưa được duyệt vào đề tài
	private Long xoaproject; // thuộc tính thể hiện sinh viên đang chờ giảng viên xóa khỏi đề tài do nhóm
								// trưởng yêu cầu:
								// 1: Nhóm trưởng muốn xóa. 0: nhóm trưởng ko yêu cầu xóa

}
