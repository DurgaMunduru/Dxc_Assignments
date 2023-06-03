package com.dxc.dao;

import java.util.List;

import org.hibernate.Session;

import com.dxc.model.Employee;
import com.dxc.util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	public int saveEmployee(String name, int age, double salary) {
		
		Employee employee = new Employee();
		employee.setEmployeeName(name);
		employee.setEmployeeAge(age);
		employee.setEmployeeSalary(salary);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		int id = (Integer)session.save(employee);
		
		session.getTransaction();
		session.close();
		
		return id;
	}

	public List<Employee> getAllEmployees() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Employee> empl = (List<Employee>)session.createQuery("FROM Employee e ORDER BY e.employeeName ASC").list();
		
		session.getTransaction().commit();
		session.close();
		
		return empl;
	}

	public void updateEmployee(int id, double salary) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		Employee employee = (Employee)session.get(Employee.class, id);
		
		employee.setEmployeeSalary(salary);
		
		session.getTransaction().commit();
		session.close();
	}

	public void deleteEmployee(int id) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		Employee employee = (Employee) session.get(Employee.class, id);
		session.delete(employee);
		
		session.getTransaction().commit();
		session.close();
		
	}

	public Employee getEmployee(int id) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		Employee employee = (Employee) session.get(Employee.class, id);
		session.delete(employee);
		
		session.getTransaction().commit();
		session.close();
		
		return employee;
	}

}
