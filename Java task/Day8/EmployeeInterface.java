package com.dal.controller;

import java.io.IOException;
import java.util.List;

import com.dal.model.Employee;

public interface EmployeeInterface {
	public void addEmployee();
	public void viewEmployee();
	public List<Employee> getEmplist();
	public void serializee(List<Employee> emp) throws IOException;
	public  void deserializee(String filename) throws IOException;
	public void updateEmployee(int eno);
	public void deleteEmployee(int eno);
}
