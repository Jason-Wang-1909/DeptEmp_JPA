package net.antra.deptemp.businessLogic;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import net.antra.deptemp.entity.Department;
import net.antra.deptemp.entity.Employee;
import net.antra.deptemp.utility.JpaUtility;

public class EmployeeService {
	public List<Employee> addNewEmployee(String firstName, String lastName, String age, int deptId) throws SQLException{
		EntityManager em = JpaUtility.getEntityManager();
		em.getTransaction().begin();
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setAge(age == null ? null : Integer.parseInt(age.trim()));
		Department department = em.find(Department.class, deptId);
		employee.setDepartment(department);
		em.persist(employee);
		em.getTransaction().commit();
		em.close();
		return getEmployeeList();
	}
	public List<Employee> getEmployeeList() throws SQLException{
		EntityManager em = JpaUtility.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select e from Employee e");
		List<Employee> resList = query.getResultList();
		em.getTransaction().commit();
		return resList;
	}
}
