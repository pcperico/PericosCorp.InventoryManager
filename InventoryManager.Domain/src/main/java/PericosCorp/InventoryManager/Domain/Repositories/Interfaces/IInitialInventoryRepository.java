/**
 * IInitialInventoryRepository.java
 * Created on 4/12/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Repositories.Interfaces;

import java.util.List;

import PericosCorp.Framework.Data.IRepository;
import PericosCorp.InventoryManager.Domain.Entities.InitialInventory;

public interface IInitialInventoryRepository extends IRepository<InitialInventory> {
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	public List<InitialInventory>FindByProductAndYear(int productId, int year);
}
