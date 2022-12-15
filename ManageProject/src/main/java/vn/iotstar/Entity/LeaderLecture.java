package vn.iotstar.Entity;

import java.io.Serializable;
import java.sql.Date;


import javax.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "leaderlecture")
public class LeaderLecture  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="id")
	private int id;
	//@Column(name="name",length = 255, columnDefinition = "nvarchar(255) not null")
	private String name;
	//@Column(name="dateofbirth")
	private Date dateofbirth;
	//@Column(name="image")
	private String image;
	//@Column(name="email")
	private String email;
	//@Column(name="address", length = 255, columnDefinition = "nvarchar(255) not null")
	private String address;
	//@Column(name="isactive")

	private Boolean isactive;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}




}
