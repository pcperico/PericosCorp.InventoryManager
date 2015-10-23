package PericosCorp.InventoryManager.Domain.Repositories.Implementations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import PericosCorp.Framework.Core.Services.Interfaces.ILoggerService;
import PericosCorp.Framework.Data.Repository;
import PericosCorp.InventoryManager.Domain.Entities.Role;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IRoleRepository;


public class RoleRepository extends Repository<Role> implements IRoleRepository  {

	private ILoggerService loggerService;
	/*@Autowired
	public void setLoggerServicey(ILoggerService _loggILoggerService) {
		this.loggerService=_loggILoggerService;
	}*/
	
	private void setLoggerService()
	{
		if(loggerService==null)
		{
			@SuppressWarnings("resource")
			ApplicationContext ctx = new ClassPathXmlApplicationContext("DomainContext.xml");
			loggerService = (ILoggerService)ctx.getBean("ILoggerServiceDomain");
		}
	}
	
	
	public Boolean CreateNewRole(String name, String description) {
		try
		{
			System.out.println("role Repository");	
			setLoggerService();
			loggerService.LogInfo("test");
			/*Role r = new Role();
			r.setDescription(description);
			r.setName(name);
			Save(r);*/	
			
			return true;	
		}
		catch(Exception ex)
		{
			
			return false;
		}
		
	}

}
