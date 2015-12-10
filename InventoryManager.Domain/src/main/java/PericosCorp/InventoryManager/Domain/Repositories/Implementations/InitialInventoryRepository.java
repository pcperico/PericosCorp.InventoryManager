/**
 * InitialInventoryRepository.java
 * Created on 4/12/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Repositories.Implementations;

import java.util.List;

import org.hibernate.Query;

import PericosCorp.Framework.Data.Repository;
import PericosCorp.InventoryManager.Domain.Entities.InitialInventory;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IInitialInventoryRepository;

public class InitialInventoryRepository extends Repository<InitialInventory> implements IInitialInventoryRepository{

	/**
	 * {@inheritDoc}
	 */
	public InitialInventory FindByProductAndYear(int productId, int year) {
		try
		{
			beginOperation();
			String hql ="select ii \n"+
						"from InitialInventory ii\n"+											    
						"where ii.Product.Id="+productId+" \n"+
						"	and ii.Year="+year;
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<InitialInventory> results = query.list();
			InitialInventory res=null;
			for(InitialInventory m : results)
			{
				res =m;				
				break;				
			}
			finishOperation();			
			return res;	
		}
		catch(Exception ex)
		{
			loggerService.LogSever(ex);
			manageException(ex);
			return null;
		}
	}
	/**
	 *
	 * @author Arturo E. Salinas
	 */
}
