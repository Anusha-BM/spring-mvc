package com.gen.emp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.gen.emp.model.Employee;

import lombok.Data;

@Entity
@Data 
@Table(name="EMPLOYEE") 
public class EmployeeEntity {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column 
	private String name;
	
	@Column 
	private String email;
	
	@Column 
	private String department;
	
	@Column
	private String location;
	
	public EmployeeEntity(Employee employee) {
	this.setId(employee.getId());
	this.setName( employee.getName()); 
	this.setEmail( employee.getEmail()); 
	this.setDepartment (employee.getDepartment()); 
	this.setLocation( employee.getLocation());
	}
	public EmployeeEntity() {
	}
}
