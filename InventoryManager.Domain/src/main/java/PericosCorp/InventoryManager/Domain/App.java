/*******************************************************************************
 * AdminRolesForm
 * Created on 03-11-2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
 *******************************************************************************/
package PericosCorp.InventoryManager.Domain;



import java.time.format.DateTimeFormatter;
import java.util.Date;

import PericosCorp.InventoryManager.Domain.Entities.Employee;
import PericosCorp.InventoryManager.Domain.Repositories.Implementations.BranchRepository;
import PericosCorp.InventoryManager.Domain.Repositories.Implementations.EmployeeRepository;
import PericosCorp.InventoryManager.Domain.Services.Implementations.EmployeeService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EmployeeRepository rr = new EmployeeRepository();
    	Employee r = rr.Get(2);    	
        System.out.println( "Hello World! "+r.getFullName()+" "+r.getBranch().getName()+" "+r.getEmployeeRoles().size()+ " "+r.getEmployeeStatus().getName());
    	
    	/*BranchRepository br = new BranchRepository();
    	br.CreateNewBranch("Branch Test", "addr Test", "phone test");*/    	
    	
    	
    	
    	/*EmployeeService es = new EmployeeService();
    	es.CreateNewEmployee("firstName", "lastName", new Date(), "phone", "email", "position", new Date(),new Date(), "address", "userName", "password", new int[]{1,2,3}, 1);
    	System.out.println("done");*/  	
    }
}
