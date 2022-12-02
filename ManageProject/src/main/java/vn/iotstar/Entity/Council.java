package vn.iotstar.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "hoidong")
public class Council implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private Long id;

	private int soluongtv;

	private int idproject;

	private int idheadlecture;

	private boolean isactive;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSoluongtv() {
		return soluongtv;
	}

	public void setSoluongtv(int soluongtv) {
		this.soluongtv = soluongtv;
	}

	public int getIdproject() {
		return idproject;
	}

	public void setIdproject(int idproject) {
		this.idproject = idproject;
	}

	public int getIdheadlecture() {
		return idheadlecture;
	}

	public void setIdheadlecture(int idheadlecture) {
		this.idheadlecture = idheadlecture;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}


}
