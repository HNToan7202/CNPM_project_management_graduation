package vn.iotstar.Entity;

import java.io.Serializable;

import javax.persistence.Column;
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
@Table(name = "Account")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String email;
	private String password;
	private int roleid;
	private Boolean isactive;

	@Column(name = "resetpasswordtoken")
	private String resetpasswordtoken;

}