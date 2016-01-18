/**
 * MovementService.java
 * Created on 1/12/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Services.Implementations;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import PericosCorp.Framework.Core.NumberHelpers;
import PericosCorp.Framework.Core.Services.Interfaces.ILoggerService;
import PericosCorp.Framework.Data.HibernateUtil;
import PericosCorp.Framework.Data.Repository;
import PericosCorp.InventoryManager.Domain.Dtos.MovementDetailDto;
import PericosCorp.InventoryManager.Domain.Entities.Client;
import PericosCorp.InventoryManager.Domain.Entities.Movement;
import PericosCorp.InventoryManager.Domain.Entities.MovementDetail;
import PericosCorp.InventoryManager.Domain.Entities.Product;
import PericosCorp.InventoryManager.Domain.Entities.Provider;
import PericosCorp.InventoryManager.Domain.Services.Interfaces.IMovementService;

public class MovementService extends Repository<Movement> implements IMovementService {
	public MovementService()
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
	public int SaveMovement(Date date, String numRef, int providerId,
			int clientId, List<MovementDetailDto> details) {
		if(date == null || numRef.isEmpty() || (providerId ==0 && clientId==0) || details==null || details.size()==0)
			return 0;
		try
		{		
			session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
			Movement movement = null;
			if(providerId>0)
			{
				Provider provider= (Provider)session.get(Provider.class,providerId);
				movement = new Movement(date,numRef,provider);	
			}
			else if(clientId>0)
			{
				Client client=(Client) session.get(Client.class, clientId);
				movement = new Movement(date,numRef,client);	
			}
			Set<MovementDetail> movementDetails=new HashSet<MovementDetail>(details.size());						
			session.save(movement);			
			for(MovementDetailDto md:details)
			{
				Product prod =(Product) session.get(Product.class,md.getProductId());
				if(movement.getProvider()!=null)
				{
					double actualStock= prod.getPriceCost()*prod.getStock();
					double stockToAdd=md.getPrice()*md.getQuantity();
					double newTotal=prod.getStock()+md.getQuantity();
					prod.setStock(newTotal);
					prod.setPriceCost(NumberHelpers.RoundTo2Decimals(((actualStock+stockToAdd)/prod.getStock())));
					movementDetails.add(new MovementDetail(movement,prod,md.getQuantity(),md.getPrice(),0));
				}
				else if(movement.getClient()!=null)
				{										
					double newTotal=prod.getStock()-md.getQuantity();
					prod.setStock(newTotal);					
					movementDetails.add(new MovementDetail(movement,prod,md.getQuantity(),prod.getPriceCost(),md.getPrice()));
				}
								
				session.saveOrUpdate(prod);
							
				/*String hql ="select ii \n"+
						"from InitialInventory as ii  \n"+											    
						"where ii.Product.Id="+prod.getId()+"\n"+
						"And ii.Year="+Calendar.getInstance().get(Calendar.YEAR);
				Query query = session.createQuery(hql);
				@SuppressWarnings("unchecked")
				List<InitialInventory> initialInventoryList = query.list();
				if(initialInventoryList.isEmpty())
				{
					InitialInventory initialInventory = new InitialInventory(prod, Calendar.getInstance().get(Calendar.YEAR), new Date(), prod.getStock(), prod.getPriceCost(),movement.getId());
					session.save(initialInventory);
				}*/
			}			
			movement.setMovementDetails(movementDetails);
			session.saveOrUpdate(movement);
			session.flush();
    		tx.commit();
    		session.clear();
    		session.close();
			return 1;
				
		}
		catch(Exception ex)
		{
			//session.flush();
		    tx.rollback();
		    session.close(); 
            loggerService.LogSever(ex);
            return -1;
		}		
		
	}
	
	
	/**
	 *
	 * @author Arturo E. Salinas
	 */
}
