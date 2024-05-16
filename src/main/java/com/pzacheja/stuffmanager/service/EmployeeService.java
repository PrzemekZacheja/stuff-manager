package com.pzacheja.stuffmanager.service;

import com.pzacheja.stuffmanager.model.Employee;
import com.pzacheja.stuffmanager.repo.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public Employee addEmployee(final Employee employeeToAdd) {
		log.info("Adding employee {}", employeeToAdd);
		employeeRepository.save(employeeToAdd);
		return employeeToAdd;
	}
}