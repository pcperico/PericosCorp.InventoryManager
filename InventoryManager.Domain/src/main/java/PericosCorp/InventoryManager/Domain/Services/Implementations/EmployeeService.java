/**
 * EmployeeService.java
 * Created on 16/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Services.Implementations;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import PericosCorp.Framework.Data.Repository;
import PericosCorp.InventoryManager.Domain.Entities.Branch;
import PericosCorp.InventoryManager.Domain.Entities.Employee;
import PericosCorp.InventoryManager.Domain.Entities.EmployeeRole;
import PericosCorp.InventoryManager.Domain.Entities.Role;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IBranchRepository;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IEmployeeRepository;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IEmployeeRoleRepository;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IRoleRepository;
import PericosCorp.InventoryManager.Domain.Services.Interfaces.IEmployeeService;

@Component
public class EmployeeService extends Repository<Employee> implements IEmployeeService {
	IRoleRepository roleRepository;
	IBranchRepository branchRepository;
	IEmployeeRepository employeeRepository; 
	IEmployeeRoleRepository employeeRoleRepository;
	public EmployeeService()
	{		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("DomainServicesContext.xml");
		roleRepository= (IRoleRepository)ctx.getBean("IRoleRepository");
		branchRepository=(IBranchRepository)ctx.getBean("IBranchRepository");
		employeeRepository=(IEmployeeRepository)ctx.getBean("IEmployeeRepository");
		employeeRoleRepository=(IEmployeeRoleRepository)ctx.getBean("IEmployeeRoleRepository");
	}
	
	
	

	/**
	 * {@inheritDoc}
	 */
	public void CreateNewEmployee(String firstName, String lastName,
			Date birthDate, String phone, String email, String position,
			Date beginDate, Date endDate, String address, String userName,
			String password, int[] roleIds, int branchId) {
		
		Branch branch = branchRepository.Get(branchId);
		Employee employee = new Employee(firstName,lastName,birthDate,phone,email,position,beginDate,endDate,address,userName,password,null,branch);
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
