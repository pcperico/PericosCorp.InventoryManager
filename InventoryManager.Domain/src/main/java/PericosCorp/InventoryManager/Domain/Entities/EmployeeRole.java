/*******************************************************************************
 * EmployeeRole
 * Created on 03-11-2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
 *******************************************************************************/
package PericosCorp.InventoryManager.Domain.Entities;

import java.io.Serializable;
import java.util.Date;


/**
*
* @author Arturo E. Salinas
*/

public class EmployeeRole implements Serializable {
	public EmployeeRole() {
	};

	public EmployeeRole(Employee employee, Role role, Date creationDate,
			boolean status) {
		Employee = employee;
		Role = role;
		CreationDate = creationDate;
		Status = status;
	};

	private static final long serialVersionUID = 1L;
	private int Id;
	private Employee Employee;
	private Role Role;
	private Date CreationDate;
	private boolean Status;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Employee getEmployee() {
		return Employee;
	}

	public void setEmployee(Employee employee) {
		Employee = employee;
	}

	public Role getRole() {
		return Role;
	}

	public void setRole(Role role) {
		Role = role;
	}

	public Date getCreationDate() {
		return CreationDate;
	}

	public void setCreationDate(Date creationDate) {
		CreationDate = creationDate;
	}

	public boolean isStatus() {
		return Status;
	}

	public void setStatus(boolean status) {
		Status = status;
	}

}
