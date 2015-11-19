/**
 * ProductRepository.java
 * Created on 19/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Repositories.Implementations;

import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import PericosCorp.Framework.Core.Services.Interfaces.ILoggerService;
import PericosCorp.Framework.Data.Repository;
import PericosCorp.InventoryManager.Domain.Dtos.CategoryProductDto;
import PericosCorp.InventoryManager.Domain.Entities.ProductCategory;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IProductCategoryRepository;

public class ProductCategoryRepository extends Repository<ProductCategory> implements IProductCategoryRepository {

	/**
	 *
	 * @author Arturo E. Salinas
	 */
	public ProductCategoryRepository() {
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
	public int CreateNewProductCategory(String name, String description) {
		if(name.isEmpty() || description.isEmpty())
			return 0;
			try
			{
				ProductCategory pc = new ProductCategory(name, description);
				Save(pc);
				return 1;	
			}
			
			catch(Exception ex)
			{
				loggerService.LogSever(ex);
				return -1;	
			}	
	}

	/**
	 * {@inheritDoc}
	 */
	public int UpdateProductCategory(int id, String name, String description) {
		
		if(id==0 || name.isEmpty() || description.isEmpty())
			return 0;
		try
		{
			ProductCategory pc = Get(id);			
			pc.setName(name);
			pc.setDescription(description);			
			Update(pc);				
			return 1;	
		}
		catch(Exception ex)
		{	
			loggerService.LogSever(ex);
			return -1;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<CategoryProductDto> FilterByName(String name) {
		try
        {
            beginOperation();
            session.setCacheMode(CacheMode.IGNORE);
            Query qu = session.getNamedQuery("ProductCategory.FindByName").setString("name","%"+ name+"%");
            qu.setCacheable(false);
            @SuppressWarnings("unchecked")
			List<CategoryProductDto> categories=  qu.setResultTransformer(Transformers.aliasToBean(CategoryProductDto.class)).list();            
            session.flush();
            session.clear();
            session.close(); 
            
            return categories;
        }
        catch(Exception ex)
        {        	
        	loggerService.LogSever(ex);
            return null;
        }
	}

	/**
	 * {@inheritDoc}
	 */
	public List<CategoryProductDto> GetAllWithProductsCount() {
		try
        {
            beginOperation();
            session.setCacheMode(CacheMode.IGNORE);
            Query qu = session.getNamedQuery("ProductCategory.GetWithTotalProducts"); 
            qu.setCacheable(false);
            @SuppressWarnings("unchecked")
			List<CategoryProductDto> categories=  qu.setResultTransformer(Transformers.aliasToBean(CategoryProductDto.class)).list();            
            session.flush();
            session.clear();
            session.close();
            
            return categories;
        }
        catch(Exception ex)
        {        	
        	loggerService.LogSever(ex);
            return null;
        }
	}
	
	
	
	
	
}
