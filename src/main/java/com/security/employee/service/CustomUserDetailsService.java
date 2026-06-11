package com.security.employee.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.employee.model.Employee;
import com.security.employee.repository.EmployeeRepository;
import com.security.employee.security.SecurityUser;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final EmployeeRepository repo;

	public CustomUserDetailsService(EmployeeRepository repo) {
		this.repo = repo;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Employee employee = repo.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));

		return new SecurityUser(employee);
	}
}