/**
 * IMovementRepository.java
 * Created on 26/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Repositories.Interfaces;

import java.util.List;

import PericosCorp.Framework.Data.IRepository;
import PericosCorp.InventoryManager.Domain.Dtos.MovementDetailDto;
import PericosCorp.InventoryManager.Domain.Entities.Movement;

public interface IMovementRepository extends IRepository<Movement> {
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	
	List<Movement>GetByProduct(int productId);
	
	List<MovementDetailDto>GetMovementsByProductAndYear(int productId,int year);
}
