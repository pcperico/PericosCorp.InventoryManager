/**
 * IInitialInventoryService.java
 * Created on 12/1/2016
 * Copyright(c) 2016 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Services.Interfaces;

public interface IInitialInventoryService {
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	
	public void CloseYear(int year,int productId);
}
