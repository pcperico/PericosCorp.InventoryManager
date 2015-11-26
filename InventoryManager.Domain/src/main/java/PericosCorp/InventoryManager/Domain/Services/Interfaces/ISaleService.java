/**
 * IBuyService.java
 * Created on 24/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Services.Interfaces;

import java.util.Date;
import java.util.List;

import PericosCorp.InventoryManager.Domain.Dtos.SaleDetailDto;

public interface ISaleService {
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	
	
	/**
	 * Method to create a new sale included sale details
	 * @param date sale date
	 * @param numRef number of reference of the sale (number of receipt)
	 * @param clientId client id 
	 * @param details List of detail of the sale
	 * @return
	 * 1 if created and inserted successfully
	 * 0 if instances is incomplete therefore isn't saved,  
	 * -1 if an error happens
	 */
	public int SaveSale(Date date,String numRef, int clientId,List<SaleDetailDto>details);
}
