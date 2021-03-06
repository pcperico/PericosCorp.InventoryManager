/*******************************************************************************
 * IBranchRepository
 * Created on 03-11-2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
 *******************************************************************************/
package PericosCorp.InventoryManager.Domain.Repositories.Interfaces;

import java.util.List;

import PericosCorp.Framework.Data.IRepository;
import PericosCorp.InventoryManager.Domain.Entities.Branch;

/**
*
* @author Arturo E. Salinas
*/
public interface IBranchRepository extends IRepository<Branch> {
	/**
	 * Method to create a new instance of entity and persists it on database
	 * @param name name of the branch
	 * @param address address of the branch
	 * @param phone phone of th branch
	 * @return
	 * 1 if created and inserted successfully
	 * 0 if instances is incomplete therefore isn't saved,  
	 * -1 if an error happens
	 */
	public int CreateNewBranch(String name,String address,String phone);
	
	/**
	 * Update existing branch on bd.
	 * @param id id of branch to be updated
	 * @param name branch name
	 * @param address branch address
	 * @param phone branch phone
	 * @return 
	 * 1 if instance was updated successfully, 
	 * 0 if instances is incomplete therefore isn't updated,  
	 * -1 if an error happens
	 */
	public int UpdateBranch(int id,String name,String address,String phone);
	
	/**
	 * Method to find branches by name matches
	 * @param name name to be search on bd 
	 * @return a list of branch entites that name contains match with name param
	 */
	public List<Branch>FilterByName(String name);
	
}
