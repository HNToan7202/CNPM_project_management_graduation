package vn.iotstar.Entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
public class Lecture implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private Date dateofbirth;
	private String address;
	private String image;
	private String email;
	private boolean is_truongbomon;
	private boolean status;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user_lecture;
	
//	@OneToMany(mappedBy = "lectures",cascade = CascadeType.ALL)
//	private List<Project> project = new ArrayList<>();
	/*
	 * @ManyToOne((mappedBy = "lecturephanbien",cascade = CascadeType.) Project
	 * project = new Project();
	 */
    public Lecture()
    {
    	
    }
	public Lecture(String name, Date dateofbirth, String address, String email, boolean is_truongbomon,
			boolean status) {
		super();
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.address = address;
		this.email = email;
		this.is_truongbomon = is_truongbomon;
		this.status = status;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isIs_truongbomon() {
		return is_truongbomon;
	}

	public void setIs_truongbomon(boolean is_truongbomon) {
		this.is_truongbomon = is_truongbomon;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

}
