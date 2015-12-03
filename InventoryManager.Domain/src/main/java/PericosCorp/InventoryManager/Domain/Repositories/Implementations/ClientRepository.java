/**
 * ClientRepository.java
 * Created on 26/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Repositories.Implementations;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import PericosCorp.Framework.Core.Services.Interfaces.ILoggerService;
import PericosCorp.Framework.Data.Repository;
import PericosCorp.InventoryManager.Domain.Entities.Client;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IClientRepository;

public class ClientRepository extends Repository<Client> implements IClientRepository {
	private ILoggerService loggerService;	
	public ClientRepository() {
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
	public int CreateNewClient(String firtsName, String lastName,
			Date birthDate, String gender, String phone, String address) {
		if(firtsName.isEmpty() || lastName.isEmpty() || birthDate==null)
			return 0;
		try{			
			Date date = new Date();
			Client client = new Client();
			client.setFirstName(firtsName);
			client.setLastName(lastName);
			client.setBirthDate(birthDate);
			client.setGender(gender);
			client.setPhone(phone);
			client.setAddress(address);
			client.setClientSince(date);
			Save(client);
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
	public int UpdateClient(int id, String firtsName, String lastName,
			Date birthDate, String gender, String phone, String address) {		
		if(firtsName.isEmpty() || lastName.isEmpty() || birthDate==null)
			return 0;
		try{
			Client client = Get(id);
			client.setFirstName(firtsName);
			client.setLastName(lastName);
			client.setBirthDate(birthDate);
			client.setGender(gender);
			client.setPhone(phone);
			client.setAddress(address);
			Update(client);
			return 1;
		}
		catch(Exception ex)
		{
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
	public List<Client> FilterByName(String name) {
		try
        {
            beginOperation();
            Query qu = session.getNamedQuery("Client.FindByName").setString("name","%"+ name+"%"); 
            @SuppressWarnings("unchecked")
			List<Client> clients=  qu.setResultTransformer(Transformers.aliasToBean(Client.class)).list();            
            session.close();
            return clients;
        }
        catch(Exception ex)
        {			
        	loggerService.LogSever(ex);
            return null;
        }		
	}
}
