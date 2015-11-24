/**
 * ProductRepository.java
 * Created on 23/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Repositories.Implementations;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import PericosCorp.Framework.Core.Services.Interfaces.ILoggerService;
import PericosCorp.Framework.Data.Repository;
import PericosCorp.InventoryManager.Domain.Dtos.ProductDto;
import PericosCorp.InventoryManager.Domain.Entities.Product;
import PericosCorp.InventoryManager.Domain.Entities.Role;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IProductRepository;

public class ProductRepository extends Repository<Product> implements IProductRepository {

	public ProductRepository()
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
	public List<ProductDto> FilterByName(String name) {
		
		try
        {
            beginOperation();
            Query qu = session.getNamedQuery("Product.FindByName").setString("name","%"+ name+"%"); 
            @SuppressWarnings("unchecked")
			List<ProductDto> products=  qu.setResultTransformer(Transformers.aliasToBean(ProductDto.class)).list();            
            session.close();
            return products;
        }
        catch(Exception ex)
        {			
        	loggerService.LogSever(ex);
            return null;
        }
	}
	/**
	 *
	 * @author Arturo E. Salinas
	 */
}
