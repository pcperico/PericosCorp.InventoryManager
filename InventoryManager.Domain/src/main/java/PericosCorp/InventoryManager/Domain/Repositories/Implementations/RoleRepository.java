package PericosCorp.InventoryManager.Domain.Repositories.Implementations;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import PericosCorp.Framework.Core.Services.Interfaces.ILoggerService;
import PericosCorp.Framework.Data.Repository;
import PericosCorp.InventoryManager.Domain.Entities.Role;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IRoleRepository;


public class RoleRepository extends Repository<Role> implements IRoleRepository  {

	private ILoggerService loggerService;	
	
	
	public void setLoggerService()
	{
		if(loggerService==null)
		{
			@SuppressWarnings("resource")
			ApplicationContext ctx = new ClassPathXmlApplicationContext("DomainContext.xml");
			loggerService = (ILoggerService)ctx.getBean("ILoggerServiceDomain");
		}
	}
	
		
	public int CreateNewRole(String name, String description) {
		if(name.isEmpty() || description.isEmpty())
			return 0;
		try
		{
			System.out.println("role Repository");	
			setLoggerService();			
			Role r = new Role();
			r.setDescription(description);
			r.setName(name);
			Save(r);				
			return 1;	
		}
		catch(Exception ex)
		{			
			loggerService.LogSever(ex);
			return -1;
		}
		
	}
}
