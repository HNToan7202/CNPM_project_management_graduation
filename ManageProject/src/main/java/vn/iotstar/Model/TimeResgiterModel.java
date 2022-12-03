package vn.iotstar.Model;

import java.sql.Date;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeResgiterModel {
	
	
	private Long id;

	private Date createat;
	private Date finishat;
	
	private Boolean isEdit = false;
	
	
}
