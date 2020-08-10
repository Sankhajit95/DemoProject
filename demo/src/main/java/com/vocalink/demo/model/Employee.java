package com.vocalink.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {

	@ApiModelProperty(notes = "Id of employee")
	@Id
	private int empId;

	@ApiModelProperty(notes = "name of employee")
	@NotNull(message = "Employee name cannot be null")
	@NotBlank
	private String empName;
	
	@NotNull(message = "Employee email cannot be null")
	@Email(message = "Not a valid email")
	private String email;
	
	@NotNull
	@Size(min = 8, max = 12, message = "Password must be greater than 4 and less than 12 character")
	private String password;
	
	@NotNull
	private double salary;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", email=" + email + ", password=" + password
				+ ", salary=" + salary + "]";
	}

	
}
