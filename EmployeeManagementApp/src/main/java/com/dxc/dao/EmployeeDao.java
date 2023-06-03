package com.dxc.dao;

import java.util.List;

import com.dxc.model.Employee;

public interface EmployeeDao {

	int saveEmployee(String name,int age,double salary);
	
	List<Employee>getAllEmployees();
	
	void updateEmployee(int id,double salary);
	
	void deleteEmployee(int id);
	
	Employee getEmployee(int id);
	
}
