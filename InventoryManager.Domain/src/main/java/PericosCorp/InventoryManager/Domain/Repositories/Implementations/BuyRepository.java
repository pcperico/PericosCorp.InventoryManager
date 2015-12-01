/**
 * BuyRepository.java
 * Created on 24/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Repositories.Implementations;

import java.util.List;

import PericosCorp.Framework.Data.Repository;
import PericosCorp.InventoryManager.Domain.Entities.Buy;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IBuyRepository;

public class BuyRepository extends Repository<Buy> implements IBuyRepository{

	public List<Buy> GetBuysBuyProduct(int productId) {
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
