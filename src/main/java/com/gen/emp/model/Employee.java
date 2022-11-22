package com.gen.emp.model;



import com.gen.emp.entity.EmployeeEntity;

import lombok.Data;

@Data
public class Employee {
	
	private Integer id; 
	private String name;
	private String email;
	private String department;
	private String location;
	
	public Employee(EmployeeEntity employeeEntity) {
		this.setId(employeeEntity.getId());
		this.setName( employeeEntity.getName()); 
		this.setEmail( employeeEntity.getEmail()); 
		this.setDepartment (employeeEntity.getDepartment()); 
		this.setLocation( employeeEntity.getLocation());
		}
		public Employee() {
		}
}
