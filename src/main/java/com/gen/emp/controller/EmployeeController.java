package com.gen.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gen.emp.model.Employee;
import com.gen.emp.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/reademployee") 
	public String showReadEployeePage(Model model) {
		model.addAttribute("employees", employeeService.findAll()); 
		return "reademployee";

	}

	@RequestMapping("/createemployee")
	public String showCreateEmployeePage(Model model) {
		model.addAttribute("command", new Employee()); 
		return "createemployee";
	}

	@RequestMapping(value="/createemployee", method = RequestMethod.POST) 
	public String createEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee( employee) ; 
		return "redirect:/reademployee";
	}

	@RequestMapping(value = "/updateemployee/{id}")
	public String showUpdateEmployeePage(@PathVariable int id, Model model) {
		model.addAttribute("id", id); 
		model.addAttribute("command", employeeService.findByIdopt(id).orElse(null)); 
		return "updateemployee";
	}

	@RequestMapping(value = "/updateemployee/{id}",method = RequestMethod.POST) 
	public String updateEmployee(@PathVariable int id, @ModelAttribute("employee") Employee employee) {
		employeeService.updateEmployee(id, employee);
		return "redirect:/reademployee";
	}

	@RequestMapping(value ="/deleteemployee/{id}") 
	public String deleteployee(@PathVariable int id) {
		employeeService.deleteById(id); 
		return "redirect:/reademployee";

	}

}
