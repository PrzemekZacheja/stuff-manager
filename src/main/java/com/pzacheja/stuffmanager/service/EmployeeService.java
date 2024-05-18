package com.pzacheja.stuffmanager.service;

import com.pzacheja.stuffmanager.model.Employee;
import com.pzacheja.stuffmanager.repo.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
@AllArgsConstructor
class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public Employee addEmployee(final Employee employeeToAdd) {
		log.info("Adding employee {}", employeeToAdd);
		return employeeRepository.save(employeeToAdd);
	}

	List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
}