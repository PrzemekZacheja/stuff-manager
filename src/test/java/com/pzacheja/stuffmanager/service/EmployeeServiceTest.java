package com.pzacheja.stuffmanager.service;

import com.pzacheja.stuffmanager.model.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
	EmployeeRepositoryForTest employeeRepo = new EmployeeRepositoryForTest();
	EmployeeService employeeService = new EmployeeService(employeeRepo);

	@Test
	void should_add_employee_and_returned_added_employee() {
		//given
		Employee employeeToAdd = new Employee( "John", "Doe", "xxx@dot.com", "developer", "1231212", "host");
		//when
		employeeService.addEmployee(employeeToAdd);
		//then
		assertEquals(employeeRepo.findAll().size(), 1);
	}
}