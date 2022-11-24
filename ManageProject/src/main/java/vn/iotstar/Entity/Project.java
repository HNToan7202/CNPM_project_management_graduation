package vn.iotstar.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
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
@Table(name = "Projects")
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project {
	
	@Id
	@Column(name ="id" ,columnDefinition = "nvarchar(20)")
	private String id;
	
	private String name;
	private String desciption;
	private boolean is_active;
	
	
    @ManyToOne(fetch = FetchType.LAZY)
    private Lecture lectures;
	
	public Lecture getLectures() {
		return lectures;
	}
	public void setLectures(Lecture lectures) {
		this.lectures = lectures;
	}

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
	
}
