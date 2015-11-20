/**
 * IProviderRepository.java
 * Created on 20/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Repositories.Interfaces;

import java.util.List;

import PericosCorp.Framework.Data.IRepository;
import PericosCorp.InventoryManager.Domain.Entities.Provider;

public interface IProviderRepository extends IRepository<Provider> {
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	
	/**
	 * Create new instance of Provider entity.
	 * @param name provider name
	 * @param contactName name of contact of provider
	 * @param phone phone of provider
	 * @param address provider address
	 * @param country provider country
	 * @return 
	 * 1 if instance was saved successfully, 
	 * 0 if instances is incomplete therefore isn't saved, 
	 * -1 if an error happens
	 */
	
	public int CreateNewProvider(String name,String contactName,String phone,String address,String country);
	
	/**
	 * Update existing provider on bd.
	 * @param id id of provider to be updated
	 * @param name provider name
	 * @param contactName name of contact of provider
	 * @param phone phone of provider
	 * @param address provider address
	 * @param country provider country
	 * @return 
	 * 1 if instance was updated successfully,
	 * 0 if instances is incomplete therefore isn't updated, 
	 * -1 if an error happens
	 */
	
	public int UpdateProvider(int id,String name,String contactName,String phone,String address,String country);
	
	/**
	 * Method to find provider by name matches
	 * @param name name to be search on bd 
	 * @return a list of provider entites that name contains match with name param
	 */
	public List<Provider>FilterByName(String name);
}
