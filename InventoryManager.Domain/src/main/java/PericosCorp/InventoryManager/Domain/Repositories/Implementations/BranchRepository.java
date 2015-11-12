package PericosCorp.InventoryManager.Domain.Repositories.Implementations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import PericosCorp.Framework.Core.Services.Interfaces.ILoggerService;
import PericosCorp.Framework.Data.Repository;
import PericosCorp.InventoryManager.Domain.Entities.Branch;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IBranchRepository;

public class BranchRepository extends Repository<Branch> implements IBranchRepository {

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
	
	public int CreateNewBranch(String name, String address, String phone) {
		if(name.isEmpty() || address.isEmpty() || phone.isEmpty())
			return 0;
		try
		{				
			setLoggerService();			
			Branch b = new Branch(name,address,phone);
			Save(b);
			return 1;	
		}
		catch(Exception ex)
		{			
			loggerService.LogSever(ex);
			return -1;
		}		
	}
}
