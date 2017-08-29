package net.antra.deptemp.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtility {
	
	static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("dept_emp_proj_pu");
	
	private JpaUtility() {}
	
	public static EntityManager getEntityManager() {
		return EMF.createEntityManager();
	}
}