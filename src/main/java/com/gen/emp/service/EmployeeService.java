package com.gen.emp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gen.emp.model.Employee;
import com.gen.emp.entity.EmployeeEntity;
import com.gen.emp.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> findAll() {
		List< EmployeeEntity> employeeEntityList= employeeRepository.findAll(); 
		List<Employee> employeeList = employeeEntityList.stream().
				map(Employee::new).collect(Collectors.toList());
		return employeeList;
	}

	public Employee findById(int id) throws Exception {
		Optional<EmployeeEntity> employeeEntity= employeeRepository.findById(id);
		if (employeeEntity.isPresent()) {
			return new Employee(employeeEntity.get());
		}
		else {
			throw new Exception("Eployee details not found for the Id: "+id);
		}
	}

	public Employee saveEmployee( Employee employee) {

		EmployeeEntity employeeEntity= employeeRepository.save( new EmployeeEntity ( employee)); 
		return new Employee(employeeEntity);
	}

	public Employee updateEmployee(int id, Employee employee) {
		EmployeeEntity existingEmployee = employeeRepository. findById(id).orElse( null); 
		existingEmployee.setName( employee.getName()); 
		existingEmployee.setEmail( employee.getEmail()); 
		existingEmployee.setDepartment( employee.getDepartment());
		existingEmployee. setLocation(employee.getLocation()); 
		EmployeeEntity updatedEmployee=employeeRepository.save( existingEmployee); 
		return new Employee(updatedEmployee);
	}

	public void deleteById(int id) { 
		employeeRepository.deleteById(id);
	}
	
	public Optional<EmployeeEntity> findByIdopt(int id) {
		return employeeRepository.findById(id);
		
	}
}
