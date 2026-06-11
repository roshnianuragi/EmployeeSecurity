package com.security.employee.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.employee.model.Employee;
import com.security.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository repo;
	private final PasswordEncoder encoder;

	public EmployeeService(EmployeeRepository repo, PasswordEncoder encoder) {
		this.repo = repo;
		this.encoder = encoder;
	}

	// ADD
	public Employee addEmployee(Employee emp) {

		emp.setPassword(encoder.encode(emp.getPassword()));

		return repo.save(emp);
	}

	// GET ALL
	public List<Employee> getAll() {
		return repo.findAll();
	}

	// GET ONE
	public Employee getOne(Long id) {

		return repo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
	}

	// UPDATE
	public Employee updateEmployee(Long id, Employee newEmp) {

		Employee old = getOne(id);

		old.setName(newEmp.getName());
		old.setSalary(newEmp.getSalary());
		old.setDepartmentName(newEmp.getDepartmentName());

		return repo.save(old);
	}

	// DELETE
	public void deleteEmployee(Long id) {
		repo.deleteById(id);
	}
}
