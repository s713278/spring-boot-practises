package com.srtech.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Valid()
	@Size(max = 25,min = 5)
	String name;
	
	@Valid
	@Email(message = "Email is reuired.")
	String email;
	
}
