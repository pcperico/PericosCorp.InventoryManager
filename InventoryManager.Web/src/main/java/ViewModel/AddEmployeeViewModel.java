package ViewModel;

import java.util.ArrayList;
import java.util.List;

import PericosCorp.InventoryManager.Domain.Entities.Employee;
import PericosCorp.InventoryManager.Domain.Entities.Role;

public class AddEmployeeViewModel {
	public Employee getEmployee() {
		return Employee;
	}
	public void setEmployee(Employee employee) {
		Employee = employee;
	}
	public List<Role> getRoles() {
		return Roles;
	}
	public void setRoles(List<Role> roles) {
		Roles = roles;
	}
	public int getTotalRoles() {
		return Roles.size();
	}
	
	private Employee Employee;
	private List<Role> Roles = new ArrayList<Role>();
	
}
