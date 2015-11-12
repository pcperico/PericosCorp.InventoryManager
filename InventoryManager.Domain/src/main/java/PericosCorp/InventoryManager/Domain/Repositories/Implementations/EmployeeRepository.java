/*******************************************************************************
 * EmployeeRepository
 * Created on 03-11-2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
 *******************************************************************************/
package PericosCorp.InventoryManager.Domain.Repositories.Implementations;

import java.util.Date;
import java.util.Set;

import PericosCorp.Framework.Data.Repository;
import PericosCorp.InventoryManager.Domain.Entities.Employee;
import PericosCorp.InventoryManager.Domain.Entities.EmployeeRole;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IEmployeeRepository;

/**
*
* @author Arturo E. Salinas
*/
public class EmployeeRepository extends Repository<Employee> implements
		IEmployeeRepository {

	public void CreateNewEmployee(String firstName, String lastName,
			Date birthDate, String phone, String email, String position,
			Date beginDate, Date endDate, String address, String userName,
			String password, Set<EmployeeRole> employeeRoles) {
		Employee e = new Employee(firstName, lastName, birthDate, phone, email,
				position, beginDate, endDate, address, userName, password,
				employeeRoles);

		try 
        { 
			beginOperation();	
            session.save(e);             
        }
		catch(Exception he) 
        { 
            manageException(he);            
        }
		finally 
        { 
            finishOperation();
        } 	
		
	}

}
