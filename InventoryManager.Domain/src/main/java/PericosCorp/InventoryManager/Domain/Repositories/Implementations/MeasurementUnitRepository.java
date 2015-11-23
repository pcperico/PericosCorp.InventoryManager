/**
 * MeasurementUnitRepository.java
 * Created on 23/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Repositories.Implementations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import PericosCorp.Framework.Core.Services.Interfaces.ILoggerService;
import PericosCorp.Framework.Data.Repository;
import PericosCorp.InventoryManager.Domain.Entities.MeasurementUnit;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IMeasurementUnitRepository;

public class MeasurementUnitRepository extends Repository<MeasurementUnit> implements IMeasurementUnitRepository {
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	public MeasurementUnitRepository() {
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
	
	/**
	 * {@inheritDoc}
	 */
	public int CreateNewMeasurementUnit(String name, String abbreviation) {
		
		if(name.isEmpty() || abbreviation.isEmpty())
			return 0;
		try
		{
			MeasurementUnit mu = new MeasurementUnit(name,abbreviation);
			Save(mu);
			return 1;
		}
		catch(Exception ex)
		{
			loggerService.LogSever(ex);
			return -1;
		}
		
	}

	/**
	 * {@inheritDoc}
	 */
	public int UpdateMeasurementUnit(int id, String name, String abbreviation) {
		if(id==0 || name.isEmpty()|| abbreviation.isEmpty())
			return 0;
		try
		{
			MeasurementUnit mu = Get(id);
			mu.setName(name);
			mu.setAbbreviation(abbreviation);
			Update(mu);
			return 1;
		}
		catch(Exception ex)
		{
			loggerService.LogSever(ex);
			return -1;
		}		
	}
}
