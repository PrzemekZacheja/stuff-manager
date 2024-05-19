package com.pzacheja.stuffmanager.service;

import com.pzacheja.stuffmanager.model.Employee;
import com.pzacheja.stuffmanager.repo.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Log4j2
@AllArgsConstructor
@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public Employee addEmployee(final Employee employeeToAdd) {
		log.info("Adding employee {}", employeeToAdd);
		employeeToAdd.setEmployeeCode(UUID.randomUUID()
		                                  .toString());
		return employeeRepository.save(employeeToAdd);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee updateEmployee(final Employee employee) {
		log.info("Updating employee {}", employee);
		return employeeRepository.save(employee);
	}

	public void deleteEmployee(final Long id) {
		log.info("Deleting employee {}", id);
		employeeRepository.deleteById(id);
	}

	public Employee getEmployeeById(final Long id) {
		log.info("Getting employee by id {}", id);
		return employeeRepository.findById(id)
		                         .orElseThrow(() -> new EmployeeNotFoundException(STR."Employee not found with id \{id}"));
	}
}