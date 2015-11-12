/*******************************************************************************
 * RoleRepository
 * Created on 03-11-2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
 *******************************************************************************/
package PericosCorp.InventoryManager.Domain.Repositories.Implementations;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import PericosCorp.Framework.Core.Services.Interfaces.ILoggerService;
import PericosCorp.Framework.Data.Repository;
import PericosCorp.InventoryManager.Domain.Entities.Role;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IRoleRepository;

/**
*
* @author Arturo E. Salinas
*/
public class RoleRepository extends Repository<Role> implements IRoleRepository  {

	private ILoggerService loggerService;	
	
	public RoleRepository()
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
	
	public int CreateNewRole(String name, String description) {
		if(name.isEmpty() || description.isEmpty())
			return 0;
		try
		{	
			Role r = new Role();
			r.setDescription(description);
			r.setName(name);
			r.setStatus(true);
			Save(r);				
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
	public int UpdateRole(int id,String name,String description)
	{
		if(id==0 || name.isEmpty() || description.isEmpty())
			return 0;
		try
		{
			Role r = Get(id);
			r.setDescription(description);
			r.setName(name);
			Update(r);				
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
	
	public int TouchRoleStatus(int roleId)
	{
		try
		{
			Role r = Get(roleId);
			r.setStatus(!r.isStatus());
			Update(r);
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
	public List<Role> FilterByName(String name) {
        try
        {
            beginOperation();
            Query qu = session.getNamedQuery("Role.FindByName").setString("name","%"+ name+"%"); 
            @SuppressWarnings("unchecked")
			List<Role> roles=  qu.setResultTransformer(Transformers.aliasToBean(Role.class)).list();            
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
