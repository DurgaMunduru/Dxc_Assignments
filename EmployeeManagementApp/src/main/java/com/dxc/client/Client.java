package com.dxc.client;

import java.util.*;
import com.dxc.dao.*;
import com.dxc.model.Employee;

import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		EmployeeDaoImpl dao = new EmployeeDaoImpl();
		
		List<Integer> arr= new ArrayList<Integer>();
		
		while(true) {
			
			System.out.println("-------Choose the option-------");
			System.out.println("Press 1. To Save an Employee Details to DataBase");
			System.out.println("Press 2. To get the list of all Employees");
			System.out.println("Press 3. To Update the Employee details");
			System.out.println("Press 4. To Delete an Employee");
			System.out.println("Press 5. To Exit");
			
			System.out.println("Enter Your choice:");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			System.out.println();
			
			
			switch(choice) {
			
			case 1:
			{
				System.out.println("Enter the employee details: ");
				
				System.out.println();
				
				System.out.print("Enter the employeeName: ");
				String employeeName = scanner.nextLine();
				System.out.println();
				
				System.out.print("Enter the employeeAge: ");
				int employeeAge = scanner.nextInt();
				System.out.println();
				
				System.out.print("Enter the employeeSalary: ");
				double employeeSalary = scanner.nextDouble();
				System.out.println();
				
				int empId = dao.saveEmployee(employeeName, employeeAge, employeeSalary);
				
				arr.add(empId);
				
				for(Integer i : arr) {
					System.out.println(i + " ");
				}
				System.out.println(arr);
				
				System.out.println();
				System.out.println("Employee Details saved successfully with id  " + empId);
				System.out.println();
				break;
				
			}
			
			case 2:
			{		
					
					List<Employee> empl = dao.getAllEmployees();
					
					System.out.println();
					System.out.println("Here is the list of all Employees : ");
					System.out.println();
					
					for(Employee emp: empl) {
						System.out.println(emp);
					}
					
					System.out.println();
					break;
					
			
			}
			case 3:
			{
				
				System.out.print("Enter the id :");
				int empId = scanner.nextInt();
				
				System.out.print("What information do you want to update Age / Salary (1 / 2) ?: ");
				int ch = scanner.nextInt();
				scanner.nextLine();
				
				switch(ch) {
				
					case 1:
					{
						System.out.print("Enter the new age: ");
						int age = scanner.nextInt();
						
						dao.updateEmployee(empId, age);
						Employee emp = dao.getEmployee(empId);
						
						System.out.println();
						System.out.println("Updated Successfully!");
						System.out.println("Updated Employee Info: "+ emp);
						System.out.println();
						break;
					}
					
					case 2:
					{
						System.out.print("Enter the new salary: ");
						double salary = scanner.nextDouble();
						
						dao.updateEmployee(empId, salary);
						Employee emp = dao.getEmployee(empId);
						
						System.out.println();
						System.out.println("Updated Successfully!");
						System.out.println("Updated Employee Info: "+ emp);
						System.out.println();
						break;
					}
				}
				
				
				break;
				
				
			}
			
			case 4:
			{
				
				
				System.out.println("enter which id to get delete");
				int id=scanner.nextInt();
				dao.deleteEmployee(id);
				List<Employee> emp = dao.getAllEmployees();
				for(Employee e: emp) {
				System.out.println(e);
				}
				System.out.println("Succesfully deleted");
				break;
			}
			
			case 5:
			
					System.out.println("Exit");
					break;
					
					
			default:
					
					System.out.println("Wrong Choice");
					
					break;
			
			}
		
		}
		
	}
}
