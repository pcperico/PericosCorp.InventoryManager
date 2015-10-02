package PericosCorp.InventoryManager.Domain.Repositories.Interfaces;

import java.util.Date;
import java.util.Set;

import PericosCorp.Framework.Data.IRepository;
import PericosCorp.InventoryManager.Domain.Entities.Employee;
import PericosCorp.InventoryManager.Domain.Entities.EmployeeRole;

public interface IEmployeeRepository extends IRepository<Employee> {
	public void CreateNewEmployee(String firstName, String lastName, Date birthDate,
			String phone, String email, String position, Date beginDate,
			Date endDate, String address, String userName, String password,
			Set<EmployeeRole> employeeRoles);
}
