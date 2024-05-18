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

	Employee updateEmployee(final Employee employee) {
		log.info("Updating employee {}", employee);
		return employeeRepository.save(employee);
	}

	void deleteEmployee(final Long id) {
		log.info("Deleting employee {}", id);
		employeeRepository.deleteById(id);
	}

	Employee getEmployeeById(final Long id) {
		log.info("Getting employee by id {}", id);
		return employeeRepository.findById(id)
			.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id " + id));
	}
}