package PericosCorp.InventoryManager.Domain.Repositories.Interfaces;

import PericosCorp.Framework.Data.IRepository;
import PericosCorp.InventoryManager.Domain.Entities.Role;

public interface IRoleRepository extends IRepository<Role> {
	public Boolean CreateNewRole(String name,String description);

}
