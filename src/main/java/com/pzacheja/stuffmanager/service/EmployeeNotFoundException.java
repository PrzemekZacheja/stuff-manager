package com.pzacheja.stuffmanager.service;

class EmployeeNotFoundException extends RuntimeException {
	public EmployeeNotFoundException(final String message) {
		super(message);
	}
}