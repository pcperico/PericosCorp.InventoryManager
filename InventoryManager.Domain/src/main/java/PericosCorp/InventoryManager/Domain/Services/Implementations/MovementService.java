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

import PericosCorp.Framework.Core.Services.Interfaces.ILoggerService;
import PericosCorp.Framework.Data.Repository;
import PericosCorp.InventoryManager.Domain.Dtos.MovementDetailDto;
import PericosCorp.InventoryManager.Domain.Entities.Client;
import PericosCorp.InventoryManager.Domain.Entities.Movement;
import PericosCorp.InventoryManager.Domain.Entities.MovementDetail;
import PericosCorp.InventoryManager.Domain.Entities.Product;
import PericosCorp.InventoryManager.Domain.Entities.Provider;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IClientRepository;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IProductRepository;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IProviderRepository;
import PericosCorp.InventoryManager.Domain.Services.Interfaces.IMovementService;

public class MovementService extends Repository<Movement> implements IMovementService {
	private IProductRepository productRepository;
	private IProviderRepository providerRepository;
	private IClientRepository clientRepository;
	public MovementService()
	{		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("DomainServicesContext.xml");	
		productRepository =(IProductRepository)ctx.getBean("IProductRepository");		
		providerRepository=(IProviderRepository)ctx.getBean("IProviderRepository");
		clientRepository=(IClientRepository)ctx.getBean("IClientRepository");
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
			beginOperation();
			Movement movement = null;
			if(providerId>0)
			{
				Provider provider= providerRepository.Get(providerId);
				movement = new Movement(date,numRef,provider);	
			}
			else if(clientId>0)
			{
				Client client= clientRepository.Get(clientId);
				movement = new Movement(date,numRef,client);	
			}
			Set<MovementDetail> movementDetails=new HashSet<MovementDetail>(details.size());						
			session.save(movement);
			for(MovementDetailDto md:details)
			{
				Product prod = productRepository.Get(md.getProductId());				
				double actualStock= prod.getPriceCost()*prod.getStock();
				double stockToAdd=md.getPrice()*md.getQuantity();
				double newTotal=prod.getStock()+md.getQuantity();
				prod.setStock(newTotal);
				prod.setPriceCost((actualStock+stockToAdd)/prod.getStock());				
				session.update(prod);
				movementDetails.add(new MovementDetail(movement,prod,md.getQuantity(),md.getPrice()));				
			}			
			movement.setMovementDetails(movementDetails);
			session.saveOrUpdate(movement);
			finishOperation();
			return 1;
				
		}
		catch(Exception ex)
		{
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
