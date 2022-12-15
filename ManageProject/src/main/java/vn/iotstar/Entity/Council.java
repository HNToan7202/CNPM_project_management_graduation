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
public class Council implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;

	private int soluongtv;

	private int idproject;

	private int idheadlecture;

	private boolean isactive;

}
