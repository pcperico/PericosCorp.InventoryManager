/**
 * ProductService.java
 * Created on 23/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Services.Implementations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import PericosCorp.Framework.Data.Repository;
import PericosCorp.InventoryManager.Domain.Entities.MeasurementUnit;
import PericosCorp.InventoryManager.Domain.Entities.Product;
import PericosCorp.InventoryManager.Domain.Entities.ProductCategory;
import PericosCorp.InventoryManager.Domain.Entities.Provider;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IMeasurementUnitRepository;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IProductCategoryRepository;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IProviderRepository;
import PericosCorp.InventoryManager.Domain.Services.Interfaces.IProductService;

public class ProductService extends Repository<Product> implements IProductService {
	private IProductCategoryRepository productCategoryRepository;
	private IProviderRepository providerRepository;
	private IMeasurementUnitRepository measurementUnitRepository;	
	public ProductService()
	{
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("DomainServicesContext.xml");
		productCategoryRepository= (IProductCategoryRepository)ctx.getBean("IProductCategoryRepository");
		providerRepository =(IProviderRepository)ctx.getBean("IProviderRepository");
		measurementUnitRepository = (IMeasurementUnitRepository)ctx.getBean("IMeasurementUnitRepository");		
	}

	/**
	 * {@inheritDoc}
	 */
	public int CreateNewProduct(int productCategoryId, int providerId,
			int measurementId, String name, String description, String brand,
			String model) {
		if(productCategoryId == 0 || providerId ==0 || measurementId == 0 || name.isEmpty())
			return 0;
		try
		{
			ProductCategory pc = productCategoryRepository.Get(productCategoryId);
			Provider prov= providerRepository.Get(providerId);
			MeasurementUnit mu = measurementUnitRepository.Get(measurementId);		
			Product p = new Product(pc, prov, mu, name, description, brand, model);
			Save(p);
			return 1;
		}
		catch(Exception ex)
		{
			manageException(ex);   
			return -1;
		}
		
	}

	/**
	 * {@inheritDoc}
	 */	
	public int UpdateProduct(int productId,int productCategoryId, int providerId,
			int measurementId, String name, String description, String brand,
			String model) {
		
		if(productCategoryId==0|| productCategoryId == 0 || providerId ==0 || measurementId == 0 || name.isEmpty())
			return 0;
		try
		{
			ProductCategory pc = productCategoryRepository.Get(productCategoryId);
			Provider prov= providerRepository.Get(providerId);
			MeasurementUnit mu = measurementUnitRepository.Get(measurementId);		
			Product p = Get(productId);
			p.setBrand(brand);
			p.setDescription(description);
			p.setMeasurementUnit(mu);
			p.setModel(model);
			p.setName(name);
			p.setProductCategory(pc);
			p.setProvider(prov);
			Update(p);
			return 1;
		}
		catch(Exception ex)
		{
			manageException(ex);   
			return -1;
		}
	}
	/**
	 *
	 * @author Arturo E. Salinas
	 */
}
