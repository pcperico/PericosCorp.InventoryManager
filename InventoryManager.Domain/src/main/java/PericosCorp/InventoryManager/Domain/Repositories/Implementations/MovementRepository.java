/**
 * MovementRepository.java
 * Created on 26/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Repositories.Implementations;

import java.util.List;

import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import PericosCorp.Framework.Core.Services.Interfaces.ILoggerService;
import PericosCorp.Framework.Data.Repository;
import PericosCorp.InventoryManager.Domain.Entities.Movement;
import PericosCorp.InventoryManager.Domain.Entities.MovementDetail;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IMovementRepository;

public class MovementRepository extends Repository<Movement> implements IMovementRepository {

	public MovementRepository()
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
	/**
	 * {@inheritDoc}
	 */
	public List<Movement> GetByProduct(int productId) {
		try
		{
			beginOperation();
			String hql ="select m \n"+
						"from Movement as m \n"+
						"   join m.MovementDetails as md \n"+					    
						"where md.Product.Id="+productId;
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Movement> results = query.list();
			for(Movement m : results)
			{
				for(MovementDetail md : m.getMovementDetails())
				{
					System.out.println(md.getQuantity());
				}
			}
			finishOperation();
			return results;	
		}
		catch(Exception ex)
		{
			loggerService.LogSever(ex);
			manageException(ex);
			return null;
		}
		
	}
	/**
	 *
	 * @author Arturo E. Salinas
	 */
}
