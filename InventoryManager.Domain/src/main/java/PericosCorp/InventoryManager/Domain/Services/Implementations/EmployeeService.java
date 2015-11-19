/**
 * EmployeeService.java
 * Created on 16/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Services.Implementations;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import PericosCorp.Framework.Data.Repository;
import PericosCorp.InventoryManager.Domain.Entities.Branch;
import PericosCorp.InventoryManager.Domain.Entities.Employee;
import PericosCorp.InventoryManager.Domain.Entities.EmployeeRole;
import PericosCorp.InventoryManager.Domain.Entities.EmployeeStatus;
import PericosCorp.InventoryManager.Domain.Entities.Role;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IBranchRepository;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IEmployeeRepository;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IEmployeeRoleRepository;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IEmployeeStatusRepository;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IRoleRepository;
import PericosCorp.InventoryManager.Domain.Services.Interfaces.IEmployeeService;

@Component
public class EmployeeService extends Repository<Employee> implements IEmployeeService {
	IRoleRepository roleRepository;
	IBranchRepository branchRepository;
	IEmployeeRepository employeeRepository; 
	IEmployeeRoleRepository employeeRoleRepository;
	IEmployeeStatusRepository employeeStatusRepository;
	public EmployeeService()
	{		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("DomainServicesContext.xml");
		roleRepository= (IRoleRepository)ctx.getBean("IRoleRepository");
		branchRepository=(IBranchRepository)ctx.getBean("IBranchRepository");
		employeeRepository=(IEmployeeRepository)ctx.getBean("IEmployeeRepository");
		employeeRoleRepository=(IEmployeeRoleRepository)ctx.getBean("IEmployeeRoleRepository");
		employeeStatusRepository=(IEmployeeStatusRepository)ctx.getBean("IEmployeeStatusRepository");
	}
	
	
	

	/**
	 * {@inheritDoc}
	 */
	public void CreateNewEmployee(String firstName, String lastName,
			Date birthDate, String phone, String email, String position,
			Date beginDate, Date endDate, String address, String userName,
			String password, int[] roleIds, int branchId,int statusId) {
		
		Branch branch = branchRepository.Get(branchId);
		EmployeeStatus status =  employeeStatusRepository.Get(statusId);
		Employee employee = new Employee(firstName,lastName,birthDate,phone,email,position,beginDate,endDate,address,userName,password,null,branch,status);
		int id =0;
        try 
        { 
           beginOperation();           
           employee.setId(id);
           Set<EmployeeRole>employeeRoles=new HashSet<EmployeeRole>(roleIds.length);           
           Date date = new Date();
           id=(Integer) session.save(employee);
	   	   for(int i=0;i<roleIds.length;i++)
	   	   {			
	   			employeeRoles.add(new EmployeeRole(employee,roleRepository.Get(roleIds[i]),date,true));
	   			//employeeRoleRepository.Save(new EmployeeRole(employee,roleRepository.Get(roleIds[i]),date,true));
	   	   }
	   	   employee.setEmployeeRoles(employeeRoles);
	   	   session.saveOrUpdate(employee);
        }catch(Exception he) 
        {         	
            manageException(he);            
        }finally 
        { 
            finishOperation();
        } 		
	}
	/**
	 *
	 * @author Arturo E. Salinas
	 */

	public void Test() {
		Role r=  roleRepository.Get(2);
		System.out.println(r.getName()); 
	}
}
