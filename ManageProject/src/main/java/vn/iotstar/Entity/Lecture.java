package vn.iotstar.Entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@Builder
@Table(name = "Lecture")
public class Lecture implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String name;
	private Date dateofbirth;
	private String address;
	private String image;
	private String email;
	
//	private int id_project;
	
	private int idhoidong;
	
	private boolean isactive;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public int getId_project() {
//		return id_project;
//	}
//
//	public void setId_project(int id_project) {
//		this.id_project = id_project;
//	}



	public boolean isIsactive() {
		return isactive;
	}

	public int getIdhoidong() {
		return idhoidong;
	}

	public void setIdhoidong(int idhoidong) {
		this.idhoidong = idhoidong;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public Lecture(Long id, String name, Date dateofbirth, String address, String image, String email,
			int idhoidong, boolean isactive) {
		super();
		this.id = id;
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.address = address;
		this.image = image;
		this.email = email;
		//this.id_project = id_project;
		this.idhoidong = idhoidong;
		this.isactive = isactive;
	}

	public Lecture() {
		super();
	}

}
