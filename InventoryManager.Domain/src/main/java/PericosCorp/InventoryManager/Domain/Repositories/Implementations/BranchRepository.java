/*******************************************************************************
 * BranchRepository
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
import PericosCorp.InventoryManager.Domain.Entities.Branch;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IBranchRepository;

/**
*
* @author Arturo E. Salinas
*/
public class BranchRepository extends Repository<Branch> implements IBranchRepository {

	public BranchRepository() {
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
	public int CreateNewBranch(String name, String address, String phone) {
		if(name.isEmpty() || address.isEmpty())
			return 0;
		try
		{				
			Branch b = new Branch(name,address,phone.isEmpty()?"":phone);
			Save(b);
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
	
	public int UpdateBranch(int id, String name, String address, String phone) {		
		if(id==0 || name.isEmpty() || address.isEmpty())
			return 0;
		try
		{
			Branch b = Get(id);			
			b.setName(name);
			b.setAddress(address);
			b.setPhone(phone.isEmpty()?"":phone);
			Update(b);				
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
	public List<Branch> FilterByName(String name) {
		try
        {
            beginOperation();
            Query qu = session.getNamedQuery("Branch.FindByName").setString("name","%"+ name+"%"); 
            @SuppressWarnings("unchecked")
			List<Branch> roles=  qu.setResultTransformer(Transformers.aliasToBean(Branch.class)).list();            
            session.close();
            loggerService.LogInfo("Getting by name");
            return roles;
        }
        catch(Exception ex)
        {        	
        	loggerService.LogSever(ex);
            return null;
        }
	}
}
