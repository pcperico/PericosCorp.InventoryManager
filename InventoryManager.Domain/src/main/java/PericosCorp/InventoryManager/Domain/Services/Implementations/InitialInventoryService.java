/**
 * InitialInventoryService.java
 * Created on 12/1/2016
 * Copyright(c) 2016 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Services.Implementations;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import PericosCorp.Framework.Core.NumberHelpers;
import PericosCorp.Framework.Core.Services.Interfaces.ILoggerService;
import PericosCorp.Framework.Data.Repository;
import PericosCorp.InventoryManager.Domain.Dtos.MovementDetailDto;
import PericosCorp.InventoryManager.Domain.Entities.InitialInventory;
import PericosCorp.InventoryManager.Domain.Entities.Product;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IInitialInventoryRepository;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IMovementRepository;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IProductRepository;
import PericosCorp.InventoryManager.Domain.Services.Interfaces.IInitialInventoryService;

public class InitialInventoryService extends Repository<InitialInventory> implements IInitialInventoryService {
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	private IProductRepository productRepository;
	private IMovementRepository movementRepository;
	private IInitialInventoryRepository initialInventoryRepository;
	public InitialInventoryService()
	{
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("DomainServicesContext.xml");
		productRepository =(IProductRepository)ctx.getBean("IProductRepository");
		movementRepository=(IMovementRepository)ctx.getBean("IMovementRepository");
		initialInventoryRepository = (IInitialInventoryRepository)ctx.getBean("IInitialInventoryRepository");
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
	public void CloseYear(int year) {
		try{		
	        List<Product> products = productRepository.GetAll();
	        for(Product prod:products)
	        {
	        	InitialInventory initialInventory =initialInventoryRepository.FindByProductAndYear(prod.getId(), year-1);
	        	List<MovementDetailDto>movements = movementRepository.GetMovementsByProductAndYear(prod.getId(), year);
	        	double Stock=initialInventory==null? 0:initialInventory.getStock();
	        	double PriceCost=initialInventory==null? 0:initialInventory.getPriceCost();	    
	        	double aux=0;	        		        		
	        	for(MovementDetailDto mov:movements)
		        {
		        	if(mov.getMovementType()==2)
		        	{		        			
		        		aux= (Stock * PriceCost)+(mov.getQuantity()*mov.getPrice());
		        		Stock+=mov.getQuantity();
		        		PriceCost = NumberHelpers.RoundTo2Decimals(aux / Stock);
		        	}
		        	else
		        	{
		        		Stock-= mov.getQuantity();
		        	}		        		
		        }
				initialInventory = new InitialInventory(prod, year+1, new Date(), Stock, PriceCost,0);
				Save(initialInventory);
	        }
		}
		catch(Exception ex)
		{
			session.flush();
		    tx.rollback();
		    session.close(); 
            loggerService.LogSever(ex);
		}
		
		
	}

	/**
	 * {@inheritDoc}
	 */
	public List<MovementDetailDto> GenerateKardex(int productId, int year) {
		try
		{	
		
			List<MovementDetailDto> res = movementRepository.GetMovementsByProductAndYear(productId, year);
			InitialInventory initialInventory = initialInventoryRepository.FindByProductAndYear(productId, year);
			double stock=initialInventory!=null ? initialInventory.getStock():0;
			double priceCost=initialInventory!=null ?initialInventory.getPriceCost():0;			
			double aux=0;	        		        		
        	for(MovementDetailDto mov:res)
	        {
	        	if(mov.getMovementType()==2)
	        	{		        			
	        		aux= (stock * priceCost)+(mov.getQuantity()*mov.getPrice());
	        		stock+=mov.getQuantity();
	        		priceCost = NumberHelpers.RoundTo2Decimals(aux / stock);
	        	}
	        	else
	        	{
	        		stock-= mov.getQuantity();
	        	}		        		
	        }
        	if(initialInventory!=null)
			{
				MovementDetailDto initial=new MovementDetailDto();
				initial.setMovementType(0); //0 denotes iniventory initial
				initial.setPrice(initialInventory.getPriceCost());
				initial.setQuantity(initialInventory.getStock());
				initial.setProductId(initialInventory.getProduct().getId());
				initial.setOperationDate(initialInventory.getCreationDate());
				res.add(0,initial);
			}
        	MovementDetailDto balance = new MovementDetailDto();
        	balance.setMovementType(3); //3 denotes balance
        	balance.setOperationDate(null);
        	balance.setPrice(priceCost);
        	balance.setQuantity(stock);
        	balance.setProductId(productId);
        	res.add(balance);			
			return res;	
		}
		catch(Exception ex)
		{
			loggerService.LogSever(ex);
			manageException(ex);
			return null;
		}		
	}
	
}
