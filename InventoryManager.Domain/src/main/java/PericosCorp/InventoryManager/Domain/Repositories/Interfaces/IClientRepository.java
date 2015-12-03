/**
 * IClientRepository.java
 * Created on 26/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Repositories.Interfaces;

import java.util.Date;
import java.util.List;

import PericosCorp.Framework.Data.IRepository;
import PericosCorp.InventoryManager.Domain.Entities.Client;

public interface IClientRepository extends IRepository<Client> {
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	/**
	 * Create new instance of client entity.
	 * Save the instance on bd. 
	 * @param firtsName client FirstName
	 * @param lastName client LastName
	 * @param birthDate client BirthDate
	 * @param gender client Gender
	 * @param phone client phone
	 * @param address client address
	 * @return 
	 * 1 if instance was saved successfully, 
	 * 0 if instances is incomplete therefore isn't saved, 
	 * -1 if an error happens
	 */
	public int CreateNewClient(String firtsName,String lastName,Date birthDate, String gender, String phone, String address);
	
	/**
	 * Update existing client on bd.
	 * @param id id of client to be updated
	 * @param firtsName client FirstName
	 * @param lastName client LastName
	 * @param birthDate client BirthDate
	 * @param gender client Gender
	 * @param phone client phone
	 * @param address client address
	 * @return 
	 * 1 if instance was updated successfully, 
	 * 0 if instances is incomplete therefore isn't updated, 
	 * -1 if an error happens
	 */	
	public int UpdateClient(int id,String firtsName,String lastName,Date birthDate, String gender, String phone, String address);
	
	/**
	 * Method to search clients by name
	 * @param name param to search on db 
	 * @return
	 * List of clients filtered by name
	 */
	public List<Client> FilterByName(String name);
}
