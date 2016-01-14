/**
 * InitialInventoryService.java
 * Created on 12/1/2016
 * Copyright(c) 2016 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Services.Implementations;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import PericosCorp.Framework.Core.Services.Interfaces.ILoggerService;
import PericosCorp.Framework.Data.HibernateUtil;
import PericosCorp.Framework.Data.Repository;
import PericosCorp.InventoryManager.Domain.Entities.InitialInventory;
import PericosCorp.InventoryManager.Domain.Entities.Product;
import PericosCorp.InventoryManager.Domain.Services.Interfaces.IInitialInventoryService;

public class InitialInventoryService extends Repository<InitialInventory> implements IInitialInventoryService {
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	
	public InitialInventoryService()
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
	public void CloseYear(int year, int productId) {
		try{
			session = HibernateUtil.getSessionFactory().openSession();
	        tx = session.beginTransaction();
	        Product prod = (Product)session.get(Product.class, productId);
	        String hql ="select ii \n"+
					"from InitialInventory as ii  \n"+											    
					"where ii.Product.Id="+prod.getId()+"\n"+
					"And ii.Year="+Calendar.getInstance().get(Calendar.YEAR);
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<InitialInventory> initialInventoryList = query.list();
			if(initialInventoryList.isEmpty())
			{
				InitialInventory initialInventory = new InitialInventory(prod, Calendar.getInstance().get(Calendar.YEAR), new Date(), prod.getStock(), prod.getPriceCost(),0);
				session.save(initialInventory);
			}
			else
			{
				for(InitialInventory ii: initialInventoryList)
				{
					ii.setCreationDate( new Date());
					ii.setStock(prod.getStock());
					ii.setPriceCost(prod.getPriceCost());
					session.update(ii);
					break;
				}
			}
			session.flush();
			tx.commit();
    		session.clear();
    		session.close();
	        
		}
		catch(Exception ex)
		{
			session.flush();
		    tx.rollback();
		    session.close(); 
            loggerService.LogSever(ex);
		}
		
		
	}
	
}
