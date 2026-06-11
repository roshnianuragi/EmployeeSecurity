package com.security.employee.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.employee.model.Employee;
import com.security.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	private final EmployeeService service;

	public EmployeeController(EmployeeService service) {
		this.service = service;
	}

	// USER + ADMIN
	@GetMapping("/user/employees")
	public List<Employee> getAll() {
		return service.getAll();
	}

	// USER + ADMIN
	@GetMapping("/user/employees/{id}")
	public Employee getOne(@PathVariable Long id) {

		return service.getOne(id);
	}

	@PostMapping("/public/add")
	public Employee addEmployee(@RequestBody Employee emp) {

		return service.addEmployee(emp);
	}

	// USER + ADMIN
	@PutMapping("/user/employees/{id}")
	public Employee update(@PathVariable Long id, @RequestBody Employee emp) {

		return service.updateEmployee(id, emp);
	}

	// ADMIN ONLY
	@DeleteMapping("/admin/employees/{id}")
	public String delete(@PathVariable Long id) {

		service.deleteEmployee(id);

		return "Employee Deleted";

	}

}
