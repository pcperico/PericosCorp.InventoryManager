/**
 * ProductService.java
 * Created on 23/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Services.Implementations;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import PericosCorp.Framework.Core.Services.Interfaces.ILoggerService;
import PericosCorp.Framework.Data.Repository;
import PericosCorp.InventoryManager.Domain.Entities.MeasurementUnit;
import PericosCorp.InventoryManager.Domain.Entities.PriceSaleHistory;
import PericosCorp.InventoryManager.Domain.Entities.Product;
import PericosCorp.InventoryManager.Domain.Entities.ProductCategory;
import PericosCorp.InventoryManager.Domain.Entities.Provider;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IMeasurementUnitRepository;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IPriceSaleHistoryRepository;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IProductCategoryRepository;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IProviderRepository;
import PericosCorp.InventoryManager.Domain.Services.Interfaces.IProductService;

public class ProductService extends Repository<Product> implements IProductService {
	private IProductCategoryRepository productCategoryRepository;
	private IProviderRepository providerRepository;
	private IMeasurementUnitRepository measurementUnitRepository;
	private IPriceSaleHistoryRepository priceSaleHistoryRepository;
	public ProductService()
	{
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("DomainServicesContext.xml");
		productCategoryRepository= (IProductCategoryRepository)ctx.getBean("IProductCategoryRepository");
		providerRepository =(IProviderRepository)ctx.getBean("IProviderRepository");
		priceSaleHistoryRepository = (IPriceSaleHistoryRepository)ctx.getBean("IPriceSaleHistoryRepository");
		measurementUnitRepository = (IMeasurementUnitRepository)ctx.getBean("IMeasurementUnitRepository");	
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
	public int CreateNewProduct(int productCategoryId, int providerId,
			int measurementId, String name, String description, String brand,
			String model,double salePrice) {
		if(productCategoryId == 0 || providerId ==0 || measurementId == 0 || name.isEmpty())
			return 0;
		try
		{
			ProductCategory pc = productCategoryRepository.Get(productCategoryId);
			Provider prov= providerRepository.Get(providerId);
			MeasurementUnit mu = measurementUnitRepository.Get(measurementId);		
			Product p = new Product(pc, prov, mu, name, description, brand, model,salePrice);
			Save(p);
			PriceSaleHistory priceSaleHistory = new PriceSaleHistory(p,salePrice,new Date());
			priceSaleHistoryRepository.Save(priceSaleHistory);
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
	 * {@inheritDoc}
	 */	
	public int UpdateProduct(int productId,int productCategoryId, int providerId,
			int measurementId, String name, String description, String brand,
			String model,double salePrice) {
		
		if(productCategoryId==0|| productCategoryId == 0 || providerId ==0 || measurementId == 0 || name.isEmpty())
			return 0;
		try
		{
			ProductCategory pc = productCategoryRepository.Get(productCategoryId);
			Provider prov= providerRepository.Get(providerId);
			MeasurementUnit mu = measurementUnitRepository.Get(measurementId);		
			Product p = Get(productId);
			double stock= p.getStock();
			double costPrice=p.getPriceCost();
			p.setBrand(brand);
			p.setDescription(description);
			p.setMeasurementUnit(mu);			
			p.setModel(model);
			p.setName(name);
			p.setProductCategory(pc);
			p.setProvider(prov);	
			p.setStock(stock);
			p.setPriceCost(costPrice);
			if(p.getPriceSale() != salePrice)
			{
				PriceSaleHistory priceSaleHistory = new PriceSaleHistory(p,salePrice,new Date());
				priceSaleHistoryRepository.Save(priceSaleHistory);
			}
			p.setPriceSale(salePrice);			
			SaveUpdate(p);			
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

	
	/**
	 * {@inheritDoc}
	 */
	public void UpdatePriceCost(int productId,double quantity, double newPriceCost) {
		try{
			Product product = Get(productId);
			if(product.getPriceCost()==0)
			{
				product.setPriceCost(newPriceCost);
				product.setStock(quantity);
				SaveUpdate(product);
			}
			else
			{
				double cost=quantity*newPriceCost;
				product.setStock(product.getStock()+quantity);
				product.setPriceCost(product.getStock()/(cost+product.getPriceCost()));
				SaveUpdate(product);
			}
			
		}
		catch(Exception ex)
		{
			
		}
		
	}
}
