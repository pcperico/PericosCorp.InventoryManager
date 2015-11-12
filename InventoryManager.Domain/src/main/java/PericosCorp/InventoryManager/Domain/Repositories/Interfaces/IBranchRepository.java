package PericosCorp.InventoryManager.Domain.Repositories.Interfaces;

import PericosCorp.Framework.Data.IRepository;
import PericosCorp.InventoryManager.Domain.Entities.Branch;

public interface IBranchRepository extends IRepository<Branch> {
	/**
	 * Method to create a new instance of entity and persists it on database
	 * @param name name of the branch
	 * @param address address of the branch
	 * @param phone phone of th branch
	 * @return
	 * 1 if created and inserted successfully
	 * 0 \n
	 * 0 if instances is incomplete therefore isn't saved, \n 
	 * -1 if an error happens
	 */
	public int CreateNewBranch(String name,String address,String phone);
}
