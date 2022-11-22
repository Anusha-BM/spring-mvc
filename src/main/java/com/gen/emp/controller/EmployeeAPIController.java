package com.gen.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.gen.emp.service.EmployeeService;
import com.gen.emp.model.Employee;
import lombok.extern.slf4j.Slf4j;


@RequestMapping("employee/")
@RestController
@Slf4j
public class EmployeeAPIController {
	@Autowired 
	EmployeeService employeeservice;


	/**
	 * return all employee details
	 * @return
	 */
	@GetMapping("all") 
	public ResponseEntity<List<Employee>> getAllEmployee() { 
		try {
			List<Employee> employeeList =employeeservice.findAll();
			return new ResponseEntity<> (employeeList, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error while retriving data from db"+ e.getMessage()); 
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}


	/**
	 * return employee details based on id
	 * @param id
	 * @return
	 */
	@GetMapping("{id}") 
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) { 
		try {
			Employee getEmployee = employeeservice.findById(id); 
			return new ResponseEntity<>(getEmployee, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error while retriveing employee details from database"+ e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());

		}
	}
	
	/**
	 *  save employee details
	 * @param employee
	 * @return
	 */
	@PostMapping("save") 
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) { try {
		Employee savedEmployee =employeeservice.saveEmployee( employee);
		return new ResponseEntity<>(savedEmployee, HttpStatus.OK); 
	} catch (Exception e) {
		log.error("Erron while saving into database" + e.getMessage());
		throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
	}
	}

	/**
	 * update employee details based on id 
	 * 
	 * @param id
	 * @param employee
	 * @return
	 */
	@PostMapping("update/{id}") 
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) { 
		try {
			Employee updatedEmployee = employeeservice.updateEmployee(id, employee);
			return new ResponseEntity<>(updatedEmployee, HttpStatus.OK); 
		}catch (Exception e) {
			log.error("Error while updating in database"+ e.getMessage()); 
			throw new ResponseStatusException (HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}



}
