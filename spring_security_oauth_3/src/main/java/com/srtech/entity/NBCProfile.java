package com.srtech.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Entity
public class NBCProfile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4402370602839954938L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String emailId;

	private String pwd;

	private String firstName;
	
	private String lastName;
	
	private String role;
	
	private Boolean active;
}
