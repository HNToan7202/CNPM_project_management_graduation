package vn.iotstar.Model;

import java.sql.Date;

import javax.persistence.Column;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentModel {
	private Integer mssv;
	private String name;
	private Date dateofbirth;
	private String image;
	private String email;
	private String faculty;
	private Long idproject;
	private Boolean isleader;
	private Boolean is_active;
	private MultipartFile imageFile;
	private Boolean isEdit = false;

	@Column(nullable = true)
	private Long waitproject;// thuộc tính thể hiện sinh viên đăng ký đề tài:
	// 1: đã được duyệt vào đề tài: 0 Chưa được duyệt vào đề tài
	@Column(nullable = true)
	private Long xoaproject; // thuộc tính thể hiện sinh viên đang chờ giảng viên xóa khỏi đề tài do nhóm
	// trưởng yêu cầu:
	// 1: Nhóm trưởng muốn xóa. 0: nhóm trưởng ko yêu cầu xóa
}
