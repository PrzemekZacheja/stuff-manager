package com.pzacheja.stuffmanager.service;

import com.pzacheja.stuffmanager.model.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class EmployeeServiceTest {
	EmployeeRepositoryForTest employeeRepo = new EmployeeRepositoryForTest();
	EmployeeService employeeService = new EmployeeService(employeeRepo);

	@Test
	void should_add_employee_and_returned_added_employee() {
		//given
		Employee employeeToAdd = new Employee("John", "Doe", "xxx@dot.com", "developer", "1231212", "host");
		//when
		employeeService.addEmployee(employeeToAdd);
		//then
		assertThat(employeeRepo.findAll()
		                       .size()).isEqualTo(1);
	}

	@Test
	void should_return_two_employees() {
		//given
		Employee employeeToAdd1 = new Employee("John", "Doe", "XXXXXXXXXXX", "developer", "1231212", "host");
		Employee employeeToAdd2 = new Employee("Bruce", "Lee", "XXXXXXXXXXX", "developer", "1231212", "host");
		employeeService.addEmployee(employeeToAdd1);
		employeeService.addEmployee(employeeToAdd2);
		//when
		List<Employee> result = employeeService.getAllEmployees();
		//then
		assertThat(result).hasSize(2);
	}

	@Test
	void should_return_updated_employee() {
		//given
		Employee employeeToAdd = new Employee("John", "Doe", "XXXXXXXXXXX", "developer", "1231212", "host");
		employeeService.addEmployee(employeeToAdd);
		Employee employeeToUpdate = new Employee("Bruce", "Willis", "XXXXXXXXXXX", "developer", "1231212", "host");
		//when
		Employee result = employeeService.updateEmployee(employeeToUpdate);
		//then
		assertThat(result.getName()).isEqualTo("Bruce");
		assertThat(result.getSurname()).isEqualTo("Willis");
	}
}