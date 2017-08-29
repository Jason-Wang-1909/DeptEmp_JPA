package net.antra.deptemp.test;

import javax.persistence.EntityManager;

import net.antra.deptemp.entity.Department;
import net.antra.deptemp.entity.Employee;
import net.antra.deptemp.utility.JpaUtility;

public class Test {

	public static void main(String[] args) {
		EntityManager em = JpaUtility.getEntityManager();
		em.getTransaction().begin();
		Employee e1 = em.find(Employee.class, 6);
		em.remove(e1);
//		Employee e2 = em.find(Employee.class, 4);
//		e2.setFirstName("John");
//		e2.setLastName("Smith");
//		em.persist(e2);
//		Department dept = em.find(Department.class, 22);
//		em.remove(dept);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

}
