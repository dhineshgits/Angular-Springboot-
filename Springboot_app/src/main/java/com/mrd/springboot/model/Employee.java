package com.mrd.springboot.model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name="employees")
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String firstname;
	private String lastname;
	@Email(message = "*Enter Proper Format")
	@NotEmpty(message = "*Must not be empty")
	private String emailId;
	@Size(min = 8, message = "*Minimum 8 Charecters")
	private String password;
	@NotNull
	@DecimalMin(value = "6000000000", message = "*Enter Proper Number")
	@DecimalMax(value = "9999999999", message = "*Enter Proper Number")
	private long mobileno;
	@Past(message = "*Date Must Not be Todays or Futures Date")
	@NotNull(message = "*Must not be empty")	
	private LocalDate dob;
	@NotEmpty(message = "*Select atleast one gender")
	private String gender;
	
    public Employee(){
    	
    }
	
	public Employee(@NotNull String firstname, String lastname,
			@Email(message = "*Enter Proper Format") @NotEmpty(message = "*Must not be empty") String emailId,
			@Size(min = 8, message = "*Minimum 8 Charecters") String password,
			@NotNull @DecimalMin(value = "6000000000", message = "*Enter Proper Number") @DecimalMax(value = "9999999999", message = "*Enter Proper Number") long mobileno,
			@Past(message = "*Date Must Not be Todays or Futures Date") @NotNull(message = "*Must not be empty") LocalDate dob,
			@NotEmpty(message = "*Select atleast one gender") String gender) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailId = emailId;
		this.password = password;
		this.mobileno = mobileno;
		this.dob = dob;
		this.gender = gender;
	}
	
	
	
	
	
	
	
	
	
	
}
