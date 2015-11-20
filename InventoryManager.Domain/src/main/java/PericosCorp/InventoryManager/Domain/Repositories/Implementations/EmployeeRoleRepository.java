/**
 * EmployeeRoleRepository.java
 * Created on 16/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Repositories.Implementations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import PericosCorp.Framework.Core.Services.Interfaces.ILoggerService;
import PericosCorp.Framework.Data.Repository;
import PericosCorp.InventoryManager.Domain.Entities.EmployeeRole;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IEmployeeRoleRepository;

public class EmployeeRoleRepository extends Repository<EmployeeRole> implements IEmployeeRoleRepository{
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	public EmployeeRoleRepository()
	{
		setLoggerService();
	}
	
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
}
