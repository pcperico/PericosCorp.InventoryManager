/**
 * SaleService.java
 * Created on 26/11/2015
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
import PericosCorp.InventoryManager.Domain.Dtos.SaleDetailDto;
import PericosCorp.InventoryManager.Domain.Entities.Client;
import PericosCorp.InventoryManager.Domain.Entities.Product;
import PericosCorp.InventoryManager.Domain.Entities.Sale;
import PericosCorp.InventoryManager.Domain.Entities.SaleDetail;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IClientRepository;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IProductRepository;
import PericosCorp.InventoryManager.Domain.Services.Interfaces.ISaleService;

public class SaleService extends Repository<Sale> implements ISaleService {
	private IProductRepository productRepository;
	private IClientRepository clientRepository;
	public SaleService()
	{
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("DomainServicesContext.xml");	
		productRepository =(IProductRepository)ctx.getBean("IProductRepository");		
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
	public int SaveSale(Date date, String numRef, int clientId,
			List<SaleDetailDto> details) {
		
		if(date == null || numRef.isEmpty() || clientId ==0 || details==null || details.size()==0)
			return 0;
		try
		{		
			beginOperation();
			Client client= clientRepository.Get(clientId);
			Sale sale = new Sale(date, numRef, client);
			Set<SaleDetail> saleDetails=new HashSet<SaleDetail>(details.size());						
			session.save(sale);
			for(SaleDetailDto bd:details)
			{
				Product prod = productRepository.Get(bd.getProductId());
				prod.setStock(prod.getStock()-bd.getQuantity());								
				session.update(prod);
				saleDetails.add(new SaleDetail(sale,prod,bd.getQuantity(),bd.getPrice()));				
			}			
			sale.setSaleDetails(saleDetails);
			session.saveOrUpdate(sale);
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
