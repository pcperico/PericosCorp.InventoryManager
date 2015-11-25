/**
 * BuyService.java
 * Created on 24/11/2015
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
import PericosCorp.InventoryManager.Domain.Dtos.BuyDetailDto;
import PericosCorp.InventoryManager.Domain.Entities.Buy;
import PericosCorp.InventoryManager.Domain.Entities.BuyDetail;
import PericosCorp.InventoryManager.Domain.Entities.Provider;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IProductRepository;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IProviderRepository;
import PericosCorp.InventoryManager.Domain.Services.Interfaces.IBuyService;

public class BuyService extends Repository<Buy> implements IBuyService  {

	
	private IProductRepository productRepository;
	private IProviderRepository providerRepository;
	public BuyService()
	{
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("DomainServicesContext.xml");	
		productRepository =(IProductRepository)ctx.getBean("IProductRepository");		
		providerRepository=(IProviderRepository)ctx.getBean("IProviderRepository");
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
	public int SaveBuy(Date date, String numRef, int providerId,
			List<BuyDetailDto> details) {
		if(date == null || numRef.isEmpty() || providerId ==0 || details==null || details.size()==0)
			return 0;
		try
		{		
			beginOperation();
			Provider provider= providerRepository.Get(providerId);
			Buy buy = new Buy(date, numRef, provider);
			Set<BuyDetail> buyDetails=new HashSet<BuyDetail>(details.size());						
			session.save(buy);
			for(BuyDetailDto bd:details)
			{
				buyDetails.add(new BuyDetail(buy,productRepository.Get(bd.getProductId()),bd.getQuantity(),bd.getPrice()));
			}			
			buy.setBuyDetails(buyDetails);
			session.saveOrUpdate(buy);
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
