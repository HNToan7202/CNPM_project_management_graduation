package vn.iotstar.Entity;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name = "Project")
@NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p")
public class Project implements Serializable {

	@Id
	private Long id;

	private String name;
	private String desciption;
	private String muctieu;
	private String yeucau;
	private int soluongsv;
	private boolean isfaculty;
	private String faculty;
	private String nienkhoa;
	private float point;
	private int idtimeproject;
	private Date create_at;
	private Date update_at;
	private Long idlecture;

	private Boolean is_active;

}
