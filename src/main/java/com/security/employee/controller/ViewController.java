package com.security.employee.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.security.employee.service.EmployeeService;

@Controller
public class ViewController {

	private final EmployeeService employeeService;

	public ViewController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}

	@GetMapping("/employees")
	public String employees(Model model) {

		model.addAttribute("employees", employeeService.getAll());

		return "employees";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

}
