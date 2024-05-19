package com.pzacheja.stuffmanager.service;

public class EmployeeNotFoundException extends RuntimeException {
	public EmployeeNotFoundException(final String message) {
		super(message);
	}
}