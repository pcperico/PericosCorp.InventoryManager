/*******************************************************************************
 * Employee
 * Created on 03-11-2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
 *******************************************************************************/
package PericosCorp.InventoryManager.Domain.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
*
* @author Arturo E. Salinas
*/
public class Employee implements Serializable {
	public Employee() {
	};

	public Employee(String firstName, String lastName, Date birthDate,
			String phone, String email, String position, Date beginDate,
			Date endDate, String address, String userName, String password,
			Set<EmployeeRole> employeeRoles,Branch branch) {
		FirstName = firstName;
		LastName = lastName;
		BirthDate = birthDate;
		Phone = phone;
		Email = email;
		Position = position;
		BeginDate = beginDate;
		EndDate = endDate;
		Address = address;
		UserName = userName;
		Password = password;
		EmployeeRoles = employeeRoles;
		Branch = branch;
	}

	private static final long serialVersionUID = 1L;

	private int Id;
	private String FirstName;
	private String LastName;
	private Date BirthDate;
	private String Phone;
	private String Email;
	private String Position;
	private Date BeginDate;
	private Date EndDate;
	private String Address;
	private String UserName;
	private String Password;
	private Set<EmployeeRole> EmployeeRoles = new HashSet<EmployeeRole>(0);
	private Branch Branch;
	public Branch getBranch() {
		return Branch;
	}

	public void setBranch(Branch branch) {
		Branch = branch;
	}

	public Set<EmployeeRole> getEmployeeRoles() {
		return EmployeeRoles;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public Date getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(Date birthDate) {
		BirthDate = birthDate;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPosition() {
		return Position;
	}

	public void setPosition(String position) {
		Position = position;
	}

	public Date getBeginDate() {
		return BeginDate;
	}

	public void setBeginDate(Date beginDate) {
		BeginDate = beginDate;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String usernName) {
		UserName = usernName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public void setEmployeeRoles(Set<EmployeeRole> employeeRoles) {
		EmployeeRoles = employeeRoles;
	}
	
	public String getFullName()
	{
		return FirstName + " "+LastName; 
	}
	

}
