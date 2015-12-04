/**
 * InitialInventoryRepository.java
 * Created on 4/12/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Repositories.Implementations;

import java.util.List;

import PericosCorp.Framework.Data.Repository;
import PericosCorp.InventoryManager.Domain.Entities.InitialInventory;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IInitialInventoryRepository;

public class InitialInventoryRepository extends Repository<InitialInventory> implements IInitialInventoryRepository{

	public List<InitialInventory> FindByProductAndYear(int productId, int year) {
		/**
		 * {@inheritDoc}
		 */
		return null;
	}
	/**
	 *
	 * @author Arturo E. Salinas
	 */
}
