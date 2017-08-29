package net.antra.deptemp.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
	private Integer id;
	private String name;
	private String email;
	private Set<Employee> employeeList;
	public Department(){}
	public Department(Integer id, String name, String email, Set<Employee> empList) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.employeeList = empList;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "dept_id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "dept_name",length=100, nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "dept_email",length=150)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@OneToMany(mappedBy="department", fetch=FetchType.LAZY)
	public Set<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(Set<Employee> employeeList) {
		this.employeeList = employeeList;
	}
}
