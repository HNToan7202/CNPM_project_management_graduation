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
	private int idhoidong;
	private Boolean isactive;

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

	public int getIdhoidong() {
		return idhoidong;
	}

	public void setIdhoidong(int idhoidong) {
		this.idhoidong = idhoidong;
	}

	public Boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}
	public Lecture(Long id, String name, Date dateofbirth, String address, String image, 
			String email, int idhoidong, Boolean isactive) {
		super();
		this.id = id;
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.address = address;
		this.image = image;
		this.email = email;
		this.idhoidong = idhoidong;
		this.isactive = isactive;
	}
	public Lecture() {
		super();
	}

}
