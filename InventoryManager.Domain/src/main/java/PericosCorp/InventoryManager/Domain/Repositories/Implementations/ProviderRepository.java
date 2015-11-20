/**
 * ProviderRepository.java
 * Created on 20/11/2015
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
import PericosCorp.InventoryManager.Domain.Entities.Provider;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IProviderRepository;

public class ProviderRepository extends Repository<Provider> implements IProviderRepository{
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	public ProviderRepository()
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
	public int CreateNewProvider(String name, String contactName, String phone,
			String address, String country) {
		if(name.isEmpty() || contactName.isEmpty() || address.isEmpty() || country.isEmpty())
			return 0;
		try
		{				
			Provider p = new Provider(name,contactName,phone.isEmpty()?"":phone,address,country);
			Save(p);
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
	public int UpdateProvider(int id, String name, String contactName,
			String phone, String address, String country) {
		if(name.isEmpty() || contactName.isEmpty() || address.isEmpty() || country.isEmpty())
			return 0;
		try
		{				
			Provider p = Get(id);
			p.setName(name);
			p.setContactName(contactName);
			p.setPhone(phone);
			p.setAddress(address);
			p.setCountry(country.toUpperCase());
			SaveUpdate(p);
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
	public List<Provider> FilterByName(String name) {
		
		try
        {
            beginOperation();
            Query qu = session.getNamedQuery("Provider.FindByName").setString("name","%"+ name+"%"); 
            @SuppressWarnings("unchecked")
			List<Provider> roles=  qu.setResultTransformer(Transformers.aliasToBean(Provider.class)).list();            
            session.close();            
            return roles;
        }
        catch(Exception ex)
        {        	
        	loggerService.LogSever(ex);
            return null;
        }
	}
	
}
