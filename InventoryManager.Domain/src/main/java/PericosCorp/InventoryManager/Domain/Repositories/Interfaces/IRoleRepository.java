package PericosCorp.InventoryManager.Domain.Repositories.Interfaces;

import PericosCorp.Framework.Data.IRepository;
import PericosCorp.InventoryManager.Domain.Entities.Role;

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

}
