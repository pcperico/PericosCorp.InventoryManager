/**
 * EmployeeStatusRepository.java
 * Created on 19/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Repositories.Implementations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import PericosCorp.Framework.Core.Services.Interfaces.ILoggerService;
import PericosCorp.Framework.Data.Repository;
import PericosCorp.InventoryManager.Domain.Entities.EmployeeStatus;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IEmployeeStatusRepository;

public class EmployeeStatusRepository extends Repository<EmployeeStatus> implements IEmployeeStatusRepository {
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	public EmployeeStatusRepository()
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
