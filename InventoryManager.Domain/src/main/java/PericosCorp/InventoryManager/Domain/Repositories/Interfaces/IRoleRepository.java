/*******************************************************************************
 * IRoleRepository
 * Created on 03-11-2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
 *******************************************************************************/
package PericosCorp.InventoryManager.Domain.Repositories.Interfaces;

import java.util.List;

import PericosCorp.Framework.Data.IRepository;
import PericosCorp.InventoryManager.Domain.Entities.Role;

/**
*
* @author Arturo E. Salinas
*/
public interface IRoleRepository extends IRepository<Role> {
	
	/**
	 * Dependency Injection setter.
	 */
	
	void setLoggerService();
	
	/**
	 * Create new instance of role entity.
	 * Save the instance on bd. 
	 * @param name role name
	 * @param description role description
	 * @return 
	 * 1 if instance was saved successfully, 
	 * 0 if instances is incomplete therefore isn't saved, 
	 * -1 if an error happens
	 */
	
	public int CreateNewRole(String name,String description);
	
	/**
	 * Update existing role on bd.
	 * @param id id of role to be updated
	 * @param name role name
	 * @param description role description
	 * @return 
	 * 1 if instance was updated successfully, 
	 * 0 if instances is incomplete therefore isn't updated, 
	 * -1 if an error happens
	 */
	
	public int UpdateRole(int id,String name,String description);
	
	
	/**
	 * Method to touch status of role
	 * @param roleId id of role to touch status
	 * @return 
	 * 1 if instance was touched successfully,
	 * -1 if an error happens
	 */
	public int TouchRoleStatus(int roleId);
	
	/**
	 * Method to search roles by name
	 * @param name param to search on db 
	 * @return
	 * List of roles filtered by name
	 */
	public List<Role> FilterByName(String name);
	
	

}
