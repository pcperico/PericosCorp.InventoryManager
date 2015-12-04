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

import PericosCorp.Framework.Core.Services.Interfaces.ILoggerService;
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
		setLoggerService();
	}
	
	
	/**
	 *
	 * @author Arturo E. Salinas
	 */

	@Override
	public void setLoggerService()
	{
		if(loggerService==null)
		{
			@SuppressWarnings("resource")
			ApplicationContext ctx = new ClassPathXmlApplicationContext("DomainContext.xml");
			loggerService = (ILoggerService)ctx.getBean("ILoggerServiceDomain");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public int CreateNewEmployee(String firstName, String lastName,
			Date birthDate, String phone, String email, String position,
			Date beginDate, Date endDate, String address, String userName,
			String password, int[] roleIds, int branchId,int statusId) {
		if(firstName.isEmpty()|| lastName.isEmpty()|| birthDate==null || position.isEmpty() || beginDate==null || userName.isEmpty() || password.isEmpty() || roleIds==null || branchId==0 || statusId==0)
			return 0;
		
		Branch branch = branchRepository.Get(branchId);
		EmployeeStatus status =  employeeStatusRepository.Get(statusId);
		Employee employee = new Employee(firstName,lastName,birthDate,phone,email,position,beginDate,endDate,address,userName,password,null,branch,status);		
        try 
        { 
           beginOperation();
           Set<EmployeeRole>employeeRoles=new HashSet<EmployeeRole>(roleIds.length);           
           Date date = new Date();
           session.save(employee);
	   	   for(int i=0;i<roleIds.length;i++)
	   	   {			
	   			employeeRoles.add(new EmployeeRole(employee,(Role) session.get(Role.class, roleIds[i]),date,true));
	   	   }
	   	   employee.setEmployeeRoles(employeeRoles);
	   	   session.saveOrUpdate(employee);
        }catch(Exception he) 
        {         	
        	tx.rollback();
	        session.close(); 
	        loggerService.LogSever(he); 
            return -1;
        }finally 
        { 
        	session.flush();
    		tx.commit();
    		session.clear();
    		session.close();
        } 		
        return 1;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public int EditEmployee(int employeeId,String firstName, String lastName,
			Date birthDate, String phone, String email, String position,
			Date beginDate, Date endDate, String address, String userName,
			String password, int[] roleIds, int branchId,int statusId) {
		if(employeeId==0||firstName.isEmpty()|| lastName.isEmpty()|| birthDate==null || position.isEmpty() || beginDate==null || userName.isEmpty() || password.isEmpty() || roleIds==null || branchId==0 || statusId==0)
			return 0;
		try 
        { 
			Employee employee = employeeRepository.Get(employeeId);
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setBirthDate(birthDate);
			employee.setPhone(phone);
			employee.setEmail(email);
			employee.setPosition(position);
			employee.setBeginDate(beginDate);
			if(endDate!=null)
				employee.setEndDate(endDate);
			employee.setAddress(address);
			employee.setUserName(userName);
			employee.setPassword(password);
			Branch branch = branchRepository.Get(branchId);
			EmployeeStatus status =  employeeStatusRepository.Get(statusId);
			employee.setBranch(branch);
			employee.setEmployeeStatus(status);	        
           beginOperation();
           Set<EmployeeRole>employeeRoles=new HashSet<EmployeeRole>(roleIds.length);           
           Date date = new Date();           
           boolean add=false;
	   	   for(int i=0;i<roleIds.length;i++)
	   	   {	
               add=true;
	   		   Role r = (Role)session.get(Role.class,roleIds[i]);
	   		   for(EmployeeRole er :employee.getEmployeeRoles())
	   		   {
	   			   if(er.getRole().getId()==r.getId())
	   			   {
		   				add=false;
		   				break;
	   			   }	   				   
	   		   }
	   		   if(add)
	   		   {	   			   
	   			   employeeRoles.add(new EmployeeRole(employee,r,date,true));	   			   
	   		   }
	   	   }
	   	   if(employeeRoles.size()>0)
	   		   employee.setEmployeeRoles(employeeRoles);
	   	   session.saveOrUpdate(employee);
        }catch(Exception he) 
        {         
        	session.flush();
        	tx.rollback();
	        session.close(); 
	        loggerService.LogSever(he); 
            return -1;
        }finally 
        { 
        	session.flush();
    		tx.commit();
    		session.clear();
    		session.close();
        } 		
        return 1;
	}
}
