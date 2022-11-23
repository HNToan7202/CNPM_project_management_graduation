package vn.iotstar.Model;

public class ProjectModel {
	
private String id;
	
	private String name;
	private String desciption;
	private boolean is_active;
	
	private Long lecture_id;

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

	public Long getLecture_id() {
		return lecture_id;
	}

	public void setLecture_id(Long lecture_id) {
		this.lecture_id = lecture_id;
	}
	
	

}
