package vn.iotstar.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouncilModel {

	private Integer id;

	private int soluongtv;

	private int idproject;

	private int idheadlecture;

	private boolean isactive;

	private Boolean isEdit = false;

}
