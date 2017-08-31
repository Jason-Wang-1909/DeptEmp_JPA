package net.antra.deptemp.businessLogic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import net.antra.deptemp.entity.Department;
import net.antra.deptemp.utility.JpaUtility;

public class DepartmentService {
	public List<Department> addNewDepartment(String name, String email) {
		EntityManager em = JpaUtility.getEntityManager();
		em.getTransaction().begin();
		Department dept = new Department();
		dept.setEmail(email);
		dept.setName(name);
		em.persist(dept);
		em.getTransaction().commit();
		System.out.println("first log info");
		return getDeptList();
	}

	public List<Department> getDeptList() {
		EntityManager em = JpaUtility.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select distinct d from Department d");
		List<Department> resList = query.getResultList();
		em.getTransaction().commit();
		return resList;
	}
}
