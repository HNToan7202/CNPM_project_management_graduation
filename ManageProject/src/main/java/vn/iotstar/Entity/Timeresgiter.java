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

@SuppressWarnings("serial")

@AllArgsConstructor
@Data
@Entity
@Builder
@Table
public class Timeresgiter implements Serializable {

	public Timeresgiter() {
		super();
	}

	public Timeresgiter(Date create_at, Date finish_at) {
		super();
		this.create_at = create_at;
		this.finish_at = finish_at;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date create_at;
	private Date finish_at;
	/*
	 * @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "id", insertable = false, updatable = false,
	 * referencedColumnName = "id_timeResgiter")
	 * 
	 * @JsonBackReference private Admin admin;
	 */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	public Date getFinish_at() {
		return finish_at;
	}

	public void setFinish_at(Date finish_at) {
		this.finish_at = finish_at;
	}

}
